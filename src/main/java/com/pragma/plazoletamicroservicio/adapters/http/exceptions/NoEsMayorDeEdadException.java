package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class NoEsMayorDeEdadException extends RuntimeException{

    public NoEsMayorDeEdadException(String message) {
        super(message);
    }
}
