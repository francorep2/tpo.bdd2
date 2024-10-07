package com.tpo.bdd2.tpo.bdd2.domain;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class CreateBookingDTO {

    private String bookingId;

    private String clientId;

    private String hotelId;

    private String bookingCode = "BC-" + System.currentTimeMillis();

    private Date startDate;
    
    private Date endDate;

    private double bookingPrice;

}
