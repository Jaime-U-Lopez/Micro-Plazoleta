package com.pragma.plazoletamicroservicio.domain.spi;

import com.pragma.plazoletamicroservicio.domain.model.Plato;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;

import java.util.List;

public interface IRestaurantePersistenciaPort {

    void saveRestaurante(Restaurante restaurante);

    void deleteRestaurante(Long id);

    Restaurante getRestaurante(Long id);

    List<Restaurante> getAllRestaurante();

}
