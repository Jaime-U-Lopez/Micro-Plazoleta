package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;

public interface IPlatoServicePort {

    void guardarPlato(Plato plato);

    void deletePlato(Plato plato);

    Plato mostrarPlato(Long id);


}
