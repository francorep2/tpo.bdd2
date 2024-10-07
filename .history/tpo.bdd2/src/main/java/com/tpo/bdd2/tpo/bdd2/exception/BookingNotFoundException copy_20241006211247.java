package com.tpo.bdd2.tpo.bdd2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {
        super(Hotel.class.getCanonicalName() + " not found");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}

