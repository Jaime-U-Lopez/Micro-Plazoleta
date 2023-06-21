package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.exceptions;

public class RestauranteYaExistenteException extends RuntimeException{

    public RestauranteYaExistenteException(String message) {
        super(message);
    }
}
