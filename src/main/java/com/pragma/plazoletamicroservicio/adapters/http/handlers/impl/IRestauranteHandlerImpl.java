package com.pragma.plazoletamicroservicio.adapters.http.handlers.impl;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IRestauranteHandler;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IRestauranteRequestMapper;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IRestauranteResponseMapper;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class IRestauranteHandlerImpl implements IRestauranteHandler {

    private final IRestauranteServicePort restauranteServicePort;
    private final IRestauranteRequestMapper restauranteRequestMapper;
    private final IRestauranteResponseMapper restauranteResponseMapper;



    @Override
    public void saveRestaurante(RestauranteRequestDto restauranteRequestDto) {


        Restaurante restaurante = restauranteRequestMapper.toRestaurante(restauranteRequestDto);

        restauranteServicePort.saveRestaurante(restaurante);



    }

    @Override
    public void deleteRestaurante(RestauranteRequestDto restauranteRequestDto) {

/*

        platoResponseMapper.platoToPlatoResponse(restauranteServicePort)

        restauranteServicePort.deleteRestaurante(restauranteRequestMapper.to); (usuarioRequestMapper.toUsuario(usuarioRequestDto));

        restauranteResponseMapper. .toRestaurante(restauranteServicePort.deleteRestaurante(restauranteRequestDto);
 */


    }

    @Override
    public RestauranteResponseDto getRestaurante(Long id) {

        return restauranteResponseMapper.toRestauranteDTO(restauranteServicePort.getRestaurante(id));

    }


    @Override
    public Boolean validarUser(Long id) {

      return  null;
    }


}
