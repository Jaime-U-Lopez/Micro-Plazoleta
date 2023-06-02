package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Rol;

import java.util.List;

public interface IRolPersistencePort {

    List<Rol> getAllRoles();

    void save(Rol rol);

    void deleteRol(Rol rol);

    Rol getRole(Long id);


}
