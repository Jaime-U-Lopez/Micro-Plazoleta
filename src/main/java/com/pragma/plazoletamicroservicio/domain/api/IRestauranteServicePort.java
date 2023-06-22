package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRestauranteServicePort {

    void saveRestaurante(Restaurante restaurante);

    void deleteRestaurante(Long id );

    Restaurante getRestaurante(Long id);

    List<Restaurante> getAllRestaurante(Pageable pageable);


}
