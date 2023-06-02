package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Usuario;

public interface IUsuarioPersistencePort {

    void guardarUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Long id);
}
