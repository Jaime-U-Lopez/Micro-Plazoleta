package com.pragma.plazoletamicroservicio.adapters.http.mapper;

import com.pragma.plazoletamicroservicio.adapters.http.dto.response.UsuarioResponseDto;
import com.pragma.plazoletamicroservicio.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUsuarioResponseMapper {

    UsuarioResponseDto usuarioToUsuarioResponse(Usuario usuario);

}
