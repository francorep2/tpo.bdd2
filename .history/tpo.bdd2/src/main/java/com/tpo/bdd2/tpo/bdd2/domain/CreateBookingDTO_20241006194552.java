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

    @Field("Hotel_ID")
    private String hotelId;

    @Field("Booking_Code")
    private String bookingCode = "BC-" + System.currentTimeMillis();

    @Field("Start_Date")
    private Date startDate;
    
    @Field("End_Date")
    private Date endDate;

    @Field("Booking_Price")
    private double bookingPrice;

}
