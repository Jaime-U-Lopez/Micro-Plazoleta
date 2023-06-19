package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranteRequestDto {



    @Positive(message = "El número de teléfono debe ser positivo")
    private Long idPropietario;
    @NotBlank
    private String nombre;
    @Positive(message = "El Nit  debe ser positivo")
    @Max(value =  999999999l, message = "El Nit  debe ser menor o igual a 9999999999")
    private long nit;

    @NotBlank
    private String direccion;

    @Positive(message = "El número de teléfono debe ser positivo")
    @Max(value =  9999999999L, message = "El teléfono  debe ser menor o igual a 9999999999")
    private long telefono;

    @NotBlank
    private String UrlLogo;


}
