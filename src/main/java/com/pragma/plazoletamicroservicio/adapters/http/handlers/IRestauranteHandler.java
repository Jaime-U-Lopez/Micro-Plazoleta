package com.pragma.plazoletamicroservicio.adapters.http.handlers;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseListDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRestauranteHandler {

    void saveRestaurante(RestauranteRequestDto restauranteRequestDto);

    void deleteRestaurante(Long id );

    List<RestauranteResponseListDto> getAllRestauntes(Pageable pageable);
  RestauranteResponseDto getRestaurante(Long id);
    Boolean validarUser(Long id);



}
