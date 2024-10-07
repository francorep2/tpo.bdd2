package com.tpo.bdd2.tpo.bdd2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException() {
        super(Booking.class.getCanonicalName() + " not found");
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}

