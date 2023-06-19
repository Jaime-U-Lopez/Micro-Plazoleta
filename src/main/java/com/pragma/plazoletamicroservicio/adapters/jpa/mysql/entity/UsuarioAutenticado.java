package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity;


import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class UsuarioAutenticado {


    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<?> authorities;


    public UsuarioAutenticado(String token, String nombreUsuario) {
        this.token = token;

        this.nombreUsuario = nombreUsuario;

    }


}
