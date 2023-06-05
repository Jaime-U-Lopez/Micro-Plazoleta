package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.domain.model.Plato;

import java.util.List;

public interface   IPlatoPersistenciaPort {

    void savePlato(PlatoEntity platoEntity);

    void updatePlato(Plato plato);

    void deletePlato(Long id);

    Plato getPlato(Long id);

    List<Plato> getAllPlato();



}
