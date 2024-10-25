package com.tpo.bdd2.tpo.bdd2.model;

import java.sql.Date;
import java.util.UUID;

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

    @Field("Booking_Code")
    private String bookingCode;

    @Field("Start_Date")
    private Date startDate;
    
    @Field("End_Date")
    private Date endDate;

    @Field("Booking_Price")
    private double bookingPrice;

}
