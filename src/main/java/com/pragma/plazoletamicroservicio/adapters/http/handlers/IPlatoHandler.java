package com.pragma.plazoletamicroservicio.adapters.http.handlers;


import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;

import java.util.List;

public interface IPlatoHandler {
    List<PlatoResponseDto> getAllPlatos();
    void savePlato(PlatoRequestDto platoRequestDto);
    void deletePlato(PlatoResponseDto platoResponseDto);

    PlatoResponseDto getPlato(Long id);

}
