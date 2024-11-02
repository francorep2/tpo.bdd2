package com.tpo.bdd2.tpo.bdd2.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@Schema(description = "Información sobre una reserva")
@Document(collection = "Bookings")
public class Booking {

    @Schema(description = "ID de reserva", example = "1")
    @Id
    @Field("Booking_ID")
    private String id;

    @Schema(description = "ID del cliente", example = "1")
    @Field("Client_ID")
    private String bookClientId;

    @Schema(description = "ID del hotel", example = "1")
    @Field("Hotel_ID")
    private String bookHotelId;

    @Schema(description = "Código de reserva", example = "BC-1111")
    @Field("Code_Confirmation_Number")
    private String confirmationNumber;

    @Schema(description = "Fecha de reserva", example = "2024-10-25")
    @Field("Date")
    private LocalDate bookingDate;

    @Schema(description = "Fecha de check-in", example = "2024-10-25")
    @Field("Check_in_date")
    private LocalDate checkInDate;

    
    @Schema(description = "Fecha de check-out", example = "2024-10-26")
    @Field("Check_out_date")
    private LocalDate checkOutDate;

    @Schema(description = "Precio", example = "4000")
    @Field("Price")
    private double bookingPrice;

}
