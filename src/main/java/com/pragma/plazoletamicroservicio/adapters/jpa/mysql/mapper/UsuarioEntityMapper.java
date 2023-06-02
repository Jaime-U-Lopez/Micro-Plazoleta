package com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioEntity;
import com.pragma.plazoletamicroservicio.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface UsuarioEntityMapper {
    UsuarioEntity toEntity(Usuario usuario);
    Usuario toUsuario(UsuarioEntity usuarioEntity);

}
