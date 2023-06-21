package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.PlatoEntity;
import com.pragma.plazoletamicroservicio.domain.model.Plato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PlatoEntityMapper {
    Plato platoEntityToPlato(PlatoEntity platoEntity);

    @Mapping(target = "restauranteEntity", source = "restaurante")
    PlatoEntity platotoPlatoEntity(Plato plato);
    @Mapping(target = "restaurante", source =   "restauranteEntity")
    List<Plato> toPlatoList(List<PlatoEntity> platoEntityList);
}
