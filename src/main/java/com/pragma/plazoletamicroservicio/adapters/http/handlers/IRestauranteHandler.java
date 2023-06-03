package com.pragma.plazoletamicroservicio.adapters.http.handlers;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;

public interface IRestauranteHandler {

    void saveRestaurante(RestauranteRequestDto restauranteRequestDto);

    void deleteRestaurante(RestauranteRequestDto restauranteRequestDto);

  RestauranteResponseDto getRestaurante(Long id);
    Boolean validarUser(Long id);



}
