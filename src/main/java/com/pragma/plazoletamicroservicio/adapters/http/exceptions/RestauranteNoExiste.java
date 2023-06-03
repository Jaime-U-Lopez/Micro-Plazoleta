package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class RestauranteNoExiste extends RuntimeException {

    public RestauranteNoExiste(String message) {
        super(message);
    }

}
