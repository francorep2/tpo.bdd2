package com.tpo.bdd2.tpo.bdd2.domain;

import java.sql.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
""
@NoArgsConstructor
public class BookingDTO {

    private UUID bookingId;

    private Long clientId;

    private String hotelId;

    private String bookingCode;

    private Date startDate;
    
    private Date endDate;

    private double bookingPrice;

}
