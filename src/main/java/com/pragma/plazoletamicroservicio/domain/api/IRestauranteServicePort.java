package com.pragma.plazoletamicroservicio.domain.api;

import com.pragma.plazoletamicroservicio.domain.model.Restaurante;

public interface IRestauranteServicePort {

    void guardarRestaurante(Restaurante restaurante);

    void deleteRestaurante(Restaurante restaurante);

    Restaurante getRestaurante(Long id);


}
