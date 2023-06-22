package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlatoServicePort {

    void savePlato(Plato plato);
    void updatePlato(Plato plato);
    void deletePlato(Long id);
    void changeStatePlato(Plato plato);

    Plato getPlato(Long id);
    List<Plato> getPlatoByRestaurante(String id, String categoria , Pageable pegeable);

    List<Plato> getAllPlato();


}
