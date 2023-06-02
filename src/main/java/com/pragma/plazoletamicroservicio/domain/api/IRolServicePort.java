package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Rol;

import java.util.List;

public interface IRolServicePort {


    List<Rol> getAllRoles();

    void saveRole(Rol rol);

    void deleteRole(Rol rol);

    Rol getRole(Long id);

}
