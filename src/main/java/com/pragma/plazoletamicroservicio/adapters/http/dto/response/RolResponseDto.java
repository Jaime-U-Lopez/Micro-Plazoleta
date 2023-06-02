package com.pragma.plazoletamicroservicio.adapters.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RolResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
}
