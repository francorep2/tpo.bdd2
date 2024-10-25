package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public BookingDTO updateBooking(UUID id, BookingDTO bookingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public void deleteBooking(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBooking'");
    }

    @Override
    public Booking getBookingById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }

    @Override
    public List<Booking> getAllBookings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBookings'");
    }

    @Override
    public List<Booking> getBookingsByClientId(UUID clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingsByClientId'");
    }

}
