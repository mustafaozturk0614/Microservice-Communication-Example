package com.bilgeadam.departmantapp.exception;

import java.io.Serial;

public class ResourceNotFoundException  extends  RuntimeException{


    @Serial
    private static final long serialVersionUID = -6546833572378200357L;

    public ResourceNotFoundException(String message) {
        super(message);
    }


    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
