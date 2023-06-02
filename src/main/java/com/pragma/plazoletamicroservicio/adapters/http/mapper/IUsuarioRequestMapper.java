package com.pragma.plazoletamicroservicio.adapters.http.mapper;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.UsuarioRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy =  ReportingPolicy.IGNORE)
public interface IUsuarioRequestMapper {

    Usuario toUsuario(UsuarioRequestDto usuarioRequestDto);
}
