package com.pragma.plazoletamicroservicio.adapters.http.handlers.impl;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestUpdateDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.exceptions.RolNoExisteTipoRol;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IPlatoHandler;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IPlatoRequestMapper;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IPlatoResponseMapper;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IRestauranteResponseMapper;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.domain.api.IPlatoServicePort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class IPlatoHandlerImpl implements IPlatoHandler {

    private final IPlatoResponseMapper platoResponseMapper;
    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;





    @Override
    public List<PlatoResponseDto> getAllPlatos() {

        return platoResponseMapper.toResponseList(platoServicePort.getAllPlato());

    }

    @Override
    public void savePlato(PlatoRequestDto platoRequestDto) {


        platoServicePort.savePlato(platoRequestMapper.toPlato(platoRequestDto));
    }

    @Override
    public void updatePlato(PlatoRequestUpdateDto platoRequestUpdateDto) {


        platoServicePort.updatePlato(platoRequestMapper.updatetoPlato(platoRequestUpdateDto));

    }

    @Override
    public void deletePlato(Long id) {
        platoServicePort.deletePlato(id);


/*

        Rol rol = roleResponseMapper.toRol(rolResponseDto);
        rolServicePort.deleteRole(rol);


 */
    }

    @Override
    public PlatoResponseDto getPlato(Long id) {

        return platoResponseMapper.platoToPlatoResponse(platoServicePort.getPlato(id));

    }
}
