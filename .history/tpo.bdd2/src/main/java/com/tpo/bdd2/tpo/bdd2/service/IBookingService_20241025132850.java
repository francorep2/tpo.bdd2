package com.tpo.bdd2.tpo.bdd2.service;

import java.util.List;
import java.util.UUID;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface IBookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    
    void deleteBooking(Long id);
    
    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByClientId(Long clientId);

    List<Booking> findByConfirmationNumber(String confirmationNumber);

    List<Booking> findByGuestId(String guestId);
    List<Booking> findByBookingDate(LocalDate bookingDate);
    

}
