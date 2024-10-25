package com.tpo.bdd2.tpo.bdd2.service;

import java.time.LocalDate;
import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface IBookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    
    void deleteBooking(Long id);
    
    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByClientId(Long clientId);

    List<BookingDTO> findBookingsByConfirmationNumber(String confirmationNumber);

    List<BookingDTO> findBookingsByGuestId(String guestId);

    List<BookingDTO> findByBookingDate(LocalDate bookingDate);
    

}
