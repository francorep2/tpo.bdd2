package com.tpo.bdd2.tpo.bdd2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.exception.ClientNotFoundException;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService{

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
                Optional<Client> clientOptional = clientRepository.findById(bookingDTO.getClientId());
        if (!clientOptional.isPresent()) {
            throw new ClientNotFoundException(); // Lanzar excepción si el cliente no existe
        }
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBooking'");
    }

    @Override
    public BookingDTO deleteBooking(Long id) {
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
