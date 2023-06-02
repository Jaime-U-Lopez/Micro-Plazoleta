package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.exceptions;

public class UsuarioYaExistenteException extends RuntimeException{

    public UsuarioYaExistenteException(String message) {
        super(message);
    }
}
