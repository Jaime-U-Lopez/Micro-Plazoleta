package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RestauranteEntityMapper {
    Restaurante restauranteEntityToRestaurante(RestauranteEntity restauranteEntity);
   RestauranteEntity restaurantetoRestauranteEntity(Restaurante restaurante);
    List<Restaurante> toRestauranteList(List<RestauranteEntity> RestauranteEntityList);


}
