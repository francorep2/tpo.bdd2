package com.tpo.bdd2.tpo.bdd2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tpo.bdd2.tpo.bdd2.model.Client;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super(Client.class.getCanonicalName() + " not found");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }
}

