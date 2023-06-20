package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.model.UsuarioAutenticado;

import java.util.List;

public interface IUsuarioAutenticadoServicePort {

    void saveUser(UsuarioAutenticado usuarioAutenticado);

    void deleteUser(Long id );

    UsuarioAutenticado getUser(Long id);




}
