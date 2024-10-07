package com.tpo.bdd2.tpo.bdd2.exception;

public class RoomAlreadyExistsException extends RuntimeException {

    public HotelAlreadyExistsException(String message) {
        super(message);
    }

    public HotelAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

