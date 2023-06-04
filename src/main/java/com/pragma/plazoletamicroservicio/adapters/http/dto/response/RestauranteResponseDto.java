package com.pragma.plazoletamicroservicio.adapters.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RestauranteResponseDto {

 private Long id;
    private Long idPropietario;
    private String   nombre;
    private Long nit;
    private String direccion;
    private Long telefono;
    private String UrlLogo;

}
