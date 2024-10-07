package com.tpo.bdd2.tpo.bdd2.exception;

public class RoomAlreadyExistsException extends RuntimeException {

    public RoomAlreadyExistsException(String message) {
        super(message);
    }

    public RoomAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

