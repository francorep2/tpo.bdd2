package com.tpo.bdd2.tpo.bdd2.domain;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
impor

@Slf4j
@Data
@NoArgsConstructor
public class BookingDTO {

    private Long bookingId;

    private Long clientId;

    private Long hotelId;

    private String bookingCode;

    private LocalDate bookingDate;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private double bookingPrice;

}
