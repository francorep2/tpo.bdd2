package com.tpo.bdd2.tpo.bdd2.service;

import java.time.LocalDate;
import java.util.List;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface IBookingService {

    BookingDTO createBooking(String hotelId, String clientId,String roomId);
    
    BookingDTO updateBooking(String confitmationNumber, BookingDTO bookingDTO);
    
    void deleteBooking(String id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByClientId(String clientId);

    List<BookingDTO> findBookingsByConfirmationNumber(String confirmationNumber);

    List<BookingDTO> findBookingsByBookingDate(LocalDate bookingDate);
    

}
