package com.pragma.plazoletamicroservicio.domain.spi;

public interface IUsuarioPersistencePort {

    void guardarUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Long id);
}
