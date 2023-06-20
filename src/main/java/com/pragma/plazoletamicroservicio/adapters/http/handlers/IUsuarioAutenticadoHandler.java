package com.pragma.plazoletamicroservicio.adapters.http.handlers;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.UsuarioAutenticadoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;

import java.util.List;

public interface IUsuarioAutenticadoHandler {

    void saveUser(UsuarioAutenticadoRequestDto usuarioAutenticadoRequestDto);

    void deleteUser(Long id );






}
