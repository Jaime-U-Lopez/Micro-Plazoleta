package com.pragma.plazoletamicroservicio.adapters.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RestauranteResponseDto {
    private Long idPropietario;
    private String   nombre;
    private Long nit;
    private String direccion;
    private int telefono;
    private String UrlLogo;

}
