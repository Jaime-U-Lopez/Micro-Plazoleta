package com.pragma.plazoletamicroservicio.domain.usecase;

import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;

public class RestauranteUseCase implements IRestauranteServicePort {


    @Override
    public void guardarRestaurante(Restaurante restaurante) {



    }

    @Override
    public void deleteRestaurante(Restaurante restaurante) {

    }

    @Override
    public Restaurante getRestaurante(Long id) {
        return null;
    }
}
