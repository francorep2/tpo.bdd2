package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface IBookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(UUID id, BookingDTO bookingDTO);
    
    void deleteBooking(UUID id);
    
    Booking getBookingById(UUID id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByClientId(Long clientId);
    

}
