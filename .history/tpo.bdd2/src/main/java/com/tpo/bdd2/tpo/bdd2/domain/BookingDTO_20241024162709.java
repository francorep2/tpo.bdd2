package com.tpo.bdd2.tpo.bdd2.domain;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class BookingDTO {

    private UUID bookingId;

    private UUID clientId;

    private UUID hotelId;

    private String bookingCode;

    private Date startDate;
    
    private Date endDate;

    private double bookingPrice;

}
