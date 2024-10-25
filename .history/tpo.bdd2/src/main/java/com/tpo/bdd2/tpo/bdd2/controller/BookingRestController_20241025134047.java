package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpo.bdd2.tpo.bdd2.domain.BookingDTO;
import com.tpo.bdd2.tpo.bdd2.model.Booking;
import com.tpo.bdd2.tpo.bdd2.service.IBookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
        return ResponseEntity.noContent().build(); 
    }
    
    @Operation(summary = "Obtener reserva por Id")
    @ApiResponse(responseCode = "200", description = "Reserva encontrada")
    @GetMapping("/{bookId}")
    public Booking getBookingById(@PathVariable Long bookId) {
        return bookingService.getBookingById(bookId);
    }

    @Operation(summary = "Obtener todas las reservas")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @Operation(summary = "Obtener reservas por Id cliente")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/client/{clientId}") 
    public List<Booking> getBookingsByClientId(@PathVariable Long clientId) {
        return bookingService.getBookingsByClientId(clientId);
    }

    @Operation(summary = "Obtener reservas por número de confirmación")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/confirmation/{confirmationNumber}")
    public List<BookingDTO> findBookingsByConfirmationNumber(@PathVariable String confirmationNumber) {
        return bookingService.findBookingsByConfirmationNumber(confirmationNumber);
    }

    @Operation(summary = "Obtener reservas por ID de huésped")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/guest/{guestId}")
    public List<BookingDTO> findBookingsByGuestId(@PathVariable String guestId) {
        return bookingService.findBookingsByGuestId(guestId);
    }

    @Operation(summary = "Obtener reservas por fecha de reserva")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/date/{bookingDate}")
    public List<BookingDTO> findBookingsByBookingDate(@PathVariable String bookingDate) {
        return bookingService.findBookingsByBookingDate(java.time.LocalDate.parse(bookingDate));
    }

    
}

