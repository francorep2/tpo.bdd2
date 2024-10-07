package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

@RestController
@RequestMapping("/api/v1")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;


    BookingDTO createBooking(BookingDTO bookingDTO);
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO);
    
    BookingDTO deleteBooking(Long id);
    
    Booking getBookingById(Long id);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByClientId(Long clientId);

}