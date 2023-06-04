package com.pragma.plazoletamicroservicio.adapters.http.handlers;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PedidoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PedidoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;

import java.util.List;

public interface IPedidoHandler {

    void savePedido(PedidoRequestDto pedidoRequestDto);

    void deletePedido(Long id );

    List<PedidoResponseDto> getAllPedidos();
    PedidoResponseDto getPedido(Long id);


}
