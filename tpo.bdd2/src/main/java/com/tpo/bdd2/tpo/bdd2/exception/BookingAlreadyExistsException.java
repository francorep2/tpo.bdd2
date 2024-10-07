package com.tpo.bdd2.tpo.bdd2.exception;

public class BookingAlreadyExistsException extends RuntimeException {

    public BookingAlreadyExistsException(String message) {
        super(message);
    }

    public BookingAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

