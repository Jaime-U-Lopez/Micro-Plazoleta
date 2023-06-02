package com.pragma.plazoletamicroservicio.domain.spi;

import java.util.List;

public interface IRolPersistencePort {

    List<Rol> getAllRoles();

    void save(Rol rol);

    void deleteRol(Rol rol);

    Rol getRole(Long id);


}
