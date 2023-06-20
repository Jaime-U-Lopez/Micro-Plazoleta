package com.pragma.plazoletamicroservicio.adapters.http.handlers.impl;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.UsuarioAutenticadoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IRestauranteHandler;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IUsuarioAutenticadoHandler;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IRestauranteRequestMapper;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IRestauranteResponseMapper;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IUsuarioAutenticadoRequestMapper;
import com.pragma.plazoletamicroservicio.domain.api.IRestauranteServicePort;
import com.pragma.plazoletamicroservicio.domain.api.IUsuarioAutenticadoServicePort;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class IUsuarioAutenticadoHandlerImpl implements IUsuarioAutenticadoHandler {

    private final IUsuarioAutenticadoServicePort usuarioAutenticadoServicePort;
    private final IUsuarioAutenticadoRequestMapper usuarioAutenticadoRequestMapper;



    @Override
    public void saveUser(UsuarioAutenticadoRequestDto usuarioAutenticadoRequestDto) {

        usuarioAutenticadoServicePort.saveUser(usuarioAutenticadoRequestMapper.toUsuarioAutenticado(usuarioAutenticadoRequestDto));

    }

    @Override
    public void deleteUser(Long id) {

        usuarioAutenticadoServicePort.deleteUser(id);

    }
}
