package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

@RestController
@RequestMapping("/v1/bookings")
public class BookingRestController {

    @Autowired
    private IBookingService bookingService;

    @PostMapping    
    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }
    
    @PutMapping("/{bookId}")
    public BookingDTO updateBooking(@PathVariable Long bookId, @RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(bookId, bookingDTO);
    }
    
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookId) {
        bookingService.deleteBooking(bookId);
        return ResponseEntity.noContent().build(); // Devuelve un 204 No Content
    }
    
    @GetMapping("/{bookId}")
    public Booking getBookingById(@PathVariable Long bookId) {
        return bookingService.getBookingById(bookId);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/client/{clientId}") // Cambié la ruta para no colisionar
    public List<Booking> getBookingsByClientId(@PathVariable Long clientId) {
        return bookingService.getBookingsByClientId(clientId);
    }
}

