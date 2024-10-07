package com.tpo.bdd2.tpo.bdd2.service.impl;

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
import com.tpo.bdd2.tpo.bdd2.repository.mongo.BookingRepository;
import com.tpo.bdd2.tpo.bdd2.repository.mongo.ClientRepository;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService{

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private final AppMapper mapper;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Optional<Client> clientOptional = clientRepository.findById(bookingDTO.getClientId());
        if (!clientOptional.isPresent()) {
            throw new ClientNotFoundException();
        }

        Optional<Booking> bookingOptional = bookingRepository.findById(bookingDTO.getBookingId());
        if (bookingOptional.isPresent()) {
            throw new BookingAlreadyExistsException("Booking already exist");
        }

        Booking newBooking = mapper.bookingDTOToBooking(bookingDTO);
        newBooking.setBookingCode("BC-" + System.currentTimeMillis());
        Booking savedBooking = bookingRepository.save(newBooking);

        log.info("Booking with id {} updated successfully.", bookingDTO.getBookingId());
        return mapper.bookingToBookingDTO(savedBooking);

    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public void deleteBooking(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBooking'");
    }

    @Override
    public Booking getBookingById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingById'");
    }

    @Override
    public List<Booking> getAllBookings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBookings'");
    }

    @Override
    public List<Booking> getBookingsByClientId(Long clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBookingsByClientId'");
    }

}
