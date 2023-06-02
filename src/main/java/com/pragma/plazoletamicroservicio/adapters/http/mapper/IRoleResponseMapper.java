package com.pragma.plazoletamicroservicio.adapters.http.mapper;


import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RolResponseDto;
import com.pragma.plazoletamicroservicio.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {


    List<RolResponseDto> toResponseList(List<Rol> roleList);
    RolResponseDto toRolDTO(Rol rol);
    Rol toRol(RolResponseDto rolResponseDto);


}
