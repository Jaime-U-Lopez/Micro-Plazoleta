package com.pragma.plazoletamicroservicio.adapters.http.mapper;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PedidoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy =  ReportingPolicy.IGNORE)
public interface IPedidoRequestMapper {
    Pedido toPedido(PedidoRequestDto pedidoRequestDto);
}
