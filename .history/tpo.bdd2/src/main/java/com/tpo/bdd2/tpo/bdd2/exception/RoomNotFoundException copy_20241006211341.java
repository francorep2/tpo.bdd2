package com.tpo.bdd2.tpo.bdd2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tpo.bdd2.tpo.bdd2.model.Room;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public RoomNotFoundException() {
        super(Room.class.getCanonicalName() + " not found");
    }

    public RoomNotFoundException(String message) {
        super(message);
    }
}

