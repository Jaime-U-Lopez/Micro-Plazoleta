package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class CorreoMalFormuladoException extends RuntimeException {
    public CorreoMalFormuladoException(String message){
        super(message);
    }
}
