package com.tpo.bdd2.tpo.bdd2.service;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import java.util.List;

public interface IBookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    
    BookingDTO deleteBooking(Long id);
    
    Booking getBookingById(Long id);

    List<BookingDTO> getAllBookings();

    

}
