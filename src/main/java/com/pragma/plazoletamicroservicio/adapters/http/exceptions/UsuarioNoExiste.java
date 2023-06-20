package com.pragma.plazoletamicroservicio.adapters.http.exceptions;

public class UsuarioNoExiste extends RuntimeException {
    public UsuarioNoExiste(String message){
        super(message);
    }
}
