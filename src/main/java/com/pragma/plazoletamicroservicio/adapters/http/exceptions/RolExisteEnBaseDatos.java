package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class RolExisteEnBaseDatos extends RuntimeException {

    public RolExisteEnBaseDatos(String message) {
        super(message);
    }

}
