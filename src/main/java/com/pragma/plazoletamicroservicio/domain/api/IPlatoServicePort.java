package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;

import java.util.List;

public interface IPlatoServicePort {

    void savePlato(Plato plato);

    void deletePlato(Plato plato);

    Plato getPlato(Long id);

    List<Plato> getAllPlato();


}
