package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RolEntity;
import com.pragma.plazoletamicroservicio.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RolEntityMapper {
    Rol rolEntityToRol(RolEntity rolEntity);
   RolEntity roltoRolEntity(Rol rol);

    List<Rol> toRolList(List<RolEntity> rolEntityList);
}
