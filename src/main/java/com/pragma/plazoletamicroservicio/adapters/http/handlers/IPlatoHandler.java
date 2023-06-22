package com.pragma.plazoletamicroservicio.adapters.http.handlers;


import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoHabilitacionRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestUpdateDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlatoHandler {
    List<PlatoResponseDto> getAllPlatos();
    void savePlato(PlatoRequestDto platoRequestDto);
    void updatePlato(PlatoRequestUpdateDto platoRequestUpdateDto);
    void changeStatePlato(PlatoHabilitacionRequestDto platoHabilitacionRequestDto);

    void deletePlato(Long id);

    List<PlatoResponseDto> getPlatoByRestaurante(String id, String categoria , Pageable pegeable);
    PlatoResponseDto getPlato(Long id);

}
