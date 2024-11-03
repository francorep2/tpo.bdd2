package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.exception.HotelNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import com.tpo.bdd2.tpo.bdd2.repository.BookingMongoRepository;
import com.tpo.bdd2.tpo.bdd2.repository.ClientNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.repository.HotelNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.repository.RoomNeo4jRepository;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingServiceImpl implements IBookingService{

    @Autowired
    private BookingMongoRepository bookingMongoRepository;

    @Autowired
    private AppMapper mapper;
    
    @Autowired
    private ClientNeo4jRepository clientNeo4jRepository;

    @Autowired
    private HotelNeo4jRepository hotelNeo4jRepository;

    @Autowired
    private RoomNeo4jRepository  roomNeo4jRepository;

    @Override
    public BookingDTO createBooking(String clientId, String hotelId,String roomId) {

        Booking newBooking = new Booking(null, null, null, null, null, null, 0);

        Hotel hotel = hotelNeo4jRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException("Hotel not found"));

        if (hotel.getRooms().stream().noneMatch(room -> room.getRoomId().equals(roomId))) {
            throw new HotelNotFoundException("Room not found");
        }

        newBooking.setHotelId(hotel.getId());
        newBooking.setClientId(clientId);
        newBooking.setBookingDate(LocalDate.now());
        for (Room r : hotel.getRooms()) {
            if (r.getRoomId().equals(roomId)) {
                newBooking.setBookingPrice(r.getPrice());
                newBooking.setCheckOutDate(r.getAvailableUntil());
                newBooking.setCheckInDate(r.getAvailableFrom());

                break;
            }
        }
        newBooking.setConfirmationNumber("BC-" + System.currentTimeMillis());        
        Booking savedBooking = bookingMongoRepository.save(newBooking);

        Room room = roomNeo4jRepository.findById(roomId)
        .orElseThrow(() -> new HotelNotFoundException("Room not found"));

        room.setIsAvailable(false);
        roomNeo4jRepository.save(room);

        return mapper.bookingToBookingDTO(savedBooking);

    }

    @Override
    public BookingDTO updateBooking(String confirmationNumber, BookingDTO bookingDTO) {
        
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(confirmationNumber);
        if (!bookingOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        Booking booking = bookingOptional.get();
        booking.setConfirmationNumber(bookingDTO.getConfirmationNumber());
        booking.setBookingPrice(bookingDTO.getBookingPrice());
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setHotelId(bookingDTO.getHotelId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setClientId(bookingDTO.getClientId());
        

        Booking savedBooking = bookingMongoRepository.save(booking);

        log.info("Booking with id {} updated successfully.", confirmationNumber);
        return mapper.bookingToBookingDTO(savedBooking);
    }

    @Override
    public void deleteBooking(String id) {
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(id);
        if (!bookingOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        bookingMongoRepository.deleteById(id);
        log.info("Booking with id {} deleted successfully.", id);
    }
    @Override
    public List<Booking> getAllBookings() {
        log.info("All bookings retrieved successfully.");
        return bookingMongoRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByClientId(String clientId) {
        Optional<Client> clientOptional = clientNeo4jRepository.findById(clientId);
        if (!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        log.info("Bookings for client with id {} retrieved successfully.", clientId);
        return bookingMongoRepository.findByClientId(clientId);
    }

    @Override
    public List<BookingDTO> findBookingsByConfirmationNumber(String confirmationNumber) {
        List<Booking> bookings = bookingMongoRepository.findByConfirmationNumber(confirmationNumber);
        return mapper.bookingsToBookingDTOs(bookings);
    }

    @Override
    public List<BookingDTO> findBookingsByBookingDate(LocalDate bookingDate) {
        List<Booking> bookings = bookingMongoRepository.findByBookingDate(bookingDate);
        return mapper.bookingsToBookingDTOs(bookings);
    }

}
