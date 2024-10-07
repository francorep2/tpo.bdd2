package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface IBookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    
    BookingDTO deleteBooking(Long id);
    
    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    
    

}
