package com.pragma.plazoletamicroservicio.adapters.http.mapper;


import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestauranteResponseMapper {


    List<RestauranteResponseDto> toResponseList(List<Restaurante> restauranteList);
    RestauranteResponseDto toRestauranteDTO(Restaurante restaurante);
    Restaurante toRestaurante(RestauranteResponseDto restauranteResponseDto);


}
