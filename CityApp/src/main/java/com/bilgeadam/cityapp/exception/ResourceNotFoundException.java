package com.bilgeadam.cityapp.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = -2969487548778792421L;

    public ResourceNotFoundException(String message) {
        super(message);
    }


    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

