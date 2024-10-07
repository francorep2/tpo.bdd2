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

    BookingDTO createBooking(BookingDTO bookingDTO){
        return bookingService.createBooking(bookingDTO);
    }
    
    BookingDTO updateBooking(Long id, BookingDTO bookingDTO){
        return bookingService.updateBooking(id, bookingDTO);
    }
    
    BookingDTO deleteBooking(Long id){
        return bookingService.deleteBooking(id);
    }
    
    Booking getBookingById(Long id){
        return bookingService.getBookingById(id);
    }

    List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    List<Booking> getBookingsByClientId(Long clientId){
        return bookingService.getBookingsByClientId(clientId);
    }

}
