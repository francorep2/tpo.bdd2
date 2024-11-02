package com.tpo.bdd2.tpo.bdd2.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class BookingDTO {

    private String id;

    private String bookClientId;

    private String bookHotelId;

    private String confirmationNumber;

    private LocalDate bookingDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private double bookingPrice;

}
