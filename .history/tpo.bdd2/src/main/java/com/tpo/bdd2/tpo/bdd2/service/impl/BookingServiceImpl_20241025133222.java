package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.exception.BookingAlreadyExistsException;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.mapper.AppMapper;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.model.Client;
import com.tpo.bdd2.tpo.bdd2.repository.BookingMongoRepository;
import com.tpo.bdd2.tpo.bdd2.repository.ClientNeo4jRepository;
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

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Optional<Client> clientOptional = clientNeo4jRepository.findById(bookingDTO.getClientId());
        if (!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }
        
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(bookingDTO.getBookingId());
        if (bookingOptional.isPresent()) {
            throw new BookingAlreadyExistsException("Booking already exist");
        }

        Booking newBooking = mapper.bookingDTOToBooking(bookingDTO);
        newBooking.setBookingCode("BC-" + System.currentTimeMillis());
        Booking savedBooking = bookingMongoRepository.save(newBooking);

        log.info("Booking with id {} updated successfully.", bookingDTO.getBookingId());
        return mapper.bookingToBookingDTO(savedBooking);

    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(id);
        if (!bookingOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        Booking booking = bookingOptional.get();
        booking.setBookingCode(bookingDTO.getBookingCode());
        booking.setBookingPrice(bookingDTO.getBookingPrice());
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setHotelId(bookingDTO.getHotelId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setClientId(bookingDTO.getClientId());
        

        Booking savedBooking = bookingMongoRepository.save(booking);

        log.info("Booking with id {} updated successfully.", id);
        return mapper.bookingToBookingDTO(savedBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(id);
        if (!bookingOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        bookingMongoRepository.deleteById(id);
        log.info("Booking with id {} deleted successfully.", id);
    }

    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> bookingOptional = bookingMongoRepository.findById(id);
        if (!bookingOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        log.info("Booking with id {} retrieved successfully.", id);
        return bookingOptional.get();
    }

    @Override
    public List<Booking> getAllBookings() {
        
    }

    @Override
    public List<Booking> getBookingsByClientId(Long clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingsByClientId'");
    }

    @Override
    public List<BookingDTO> findBookingsByConfirmationNumber(String confirmationNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBookingsByConfirmationNumber'");
    }

    @Override
    public List<BookingDTO> findBookingsByGuestId(String guestId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBookingsByGuestId'");
    }

    @Override
    public List<BookingDTO> findBookingsByBookingDate(LocalDate bookingDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBookingsByBookingDate'");
    }

}