package com.pragma.plazoletamicroservicio.domain.model;

import java.util.List;

public class UsuarioAutenticado {


    private Long id;
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;

    public UsuarioAutenticado(Long id, String token, String bearer, String nombreUsuario) {
        this.id = id;
        this.token = token;
        this.bearer = bearer;
        this.nombreUsuario = nombreUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
