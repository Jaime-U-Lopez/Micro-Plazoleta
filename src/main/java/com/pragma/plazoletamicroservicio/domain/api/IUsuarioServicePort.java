package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.adapters.http.dto.TipoRol;
import com.pragma.plazoletamicroservicio.domain.model.Usuario;

public interface IUsuarioServicePort {

    void guardarUser(Usuario usuario, TipoRol rol);

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Long id);
    Boolean validarPropietario(Long id);
}
