package com.tpo.bdd2.tpo.bdd2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Operation(summary = "Crear reserva")
    @ApiResponse(responseCode = "201", description = "Reserva creada")
    @PostMapping("/{clientId}/{hotelId}/{roomId}")
    public BookingDTO createBooking(@PathVariable("clientId") String clientId,@PathVariable("hotelId") String hotelId,@PathVariable("roomId") String roomId) {
        return bookingService.createBooking(clientId,hotelId,roomId);
    }
    
    @Operation(summary = "Actualizar reserva por Id")
    @ApiResponse(responseCode = "200", description = "Reserva actualizada")
    @PutMapping("/{confirmationNumber}")
    public BookingDTO updateBooking(@PathVariable("confirmationNumber") String confirmationNumber, @RequestBody BookingDTO bookingDTO) {
        return bookingService.updateBooking(confirmationNumber, bookingDTO);
    }
    
    @Operation(summary = "Eliminar reserva por Id")
    @ApiResponse(responseCode = "204", description = "Reserva eliminada")
    @DeleteMapping("/{confirmationNumber}")
    public void deleteBooking(@PathVariable("confirmationNumber") String confirmationNumber) {
        bookingService.deleteBooking(confirmationNumber);
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
    public List<Booking> getBookingsByClientId(@PathVariable("clientId") String clientId) {
        return bookingService.getBookingsByClientId(clientId);
    }

    @Operation(summary = "Obtener reservas por número de confirmación")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/confirmation/{confirmationNumber}")
    public List<BookingDTO> findBookingsByConfirmationNumber(@PathVariable String confirmationNumber) {
        return bookingService.findBookingsByConfirmationNumber(confirmationNumber);
    }

    @Operation(summary = "Obtener reservas por fecha de reserva")
    @ApiResponse(responseCode = "200", description = "Lista de reservas encontradas")
    @GetMapping("/date/{bookingDate}")
    public List<BookingDTO> findBookingsByBookingDate(@PathVariable String bookingDate) {
        return bookingService.findBookingsByBookingDate(java.time.LocalDate.parse(bookingDate));
    }

    
}

