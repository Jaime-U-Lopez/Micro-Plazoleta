package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Plato;

import java.util.List;

public interface   IPlatoPersistenciaPort {

    void savePlato(Plato plato);

    void deletePlato(Plato plato);

    Plato getPlato(Long id);

    List<Plato> getAllPlato();



}
