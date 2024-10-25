package com.tpo.bdd2.tpo.bdd2.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Document(collection = "Bookings")
public class Booking {

    @Id
    @Field("Booking_ID")
    private Long bookingId;

    @Field("Client_ID")
    private Long clientId;

    @Field("Hotel_ID")
    private Long hotelId;

    @Field("Code_Confirmation")
    private String confirmationNumber;

    @Field("Date")
    private LocalDate bookingDate;

    @Field("Check_in_date")
    private LocalDate checkInDate;

    @Field("Check_out_date")
    private LocalDate checkOutDate;

    @Field("Price")
    private double bookingPrice;

}
