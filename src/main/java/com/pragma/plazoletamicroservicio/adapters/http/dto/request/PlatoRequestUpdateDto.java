package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoRequestUpdateDto {

    @Positive(message = "El id  debe ser positivo")
    private Long idplato;
    @Positive(message = "El precio  debe ser positivo")
    private Long precio;
    @NotBlank
    private String descripcion;









}
