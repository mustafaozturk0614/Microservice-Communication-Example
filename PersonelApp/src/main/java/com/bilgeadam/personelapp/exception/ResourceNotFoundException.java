package com.bilgeadam.personelapp.exception;

import java.io.Serial;

public class ResourceNotFoundException extends  RuntimeException {
    @Serial
    private static final long serialVersionUID = -8365898569465454265L;



    public ResourceNotFoundException(String message) {
        super(message);
    }


    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
