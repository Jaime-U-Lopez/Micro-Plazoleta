package com.pragma.plazoletamicroservicio.adapters.http.mapper;


import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PedidoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.domain.model.Pedido;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPedidoResponseMapper {

    @Mapping(target = "restauranteEntity", source = "restaurante.restaurante")
    @Mapping(target = "platoEntity", source = "plato.plato")
    List<PedidoResponseDto> toResponseList(List<Pedido> pedidoList);
    PedidoResponseDto toPedidoDTO(Pedido pedido);
    Pedido toPedido(PedidoResponseDto pedidoResponseDto);


}
