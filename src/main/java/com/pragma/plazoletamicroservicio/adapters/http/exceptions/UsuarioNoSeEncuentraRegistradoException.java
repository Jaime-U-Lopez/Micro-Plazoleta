package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class UsuarioNoSeEncuentraRegistradoException extends RuntimeException{

    public UsuarioNoSeEncuentraRegistradoException(String message) {
        super(message);
    }
}
