package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import com.pragma.plazoletamicroservicio.domain.model.UsuarioAutenticado;

import java.util.List;

public interface IUsuarioAutenticadoPersistenciaPort {


    void saveUser(UsuarioAutenticado usuarioAutenticado);

    void deleteUser(Long id );

    UsuarioAutenticado getUser(Long id);

}
