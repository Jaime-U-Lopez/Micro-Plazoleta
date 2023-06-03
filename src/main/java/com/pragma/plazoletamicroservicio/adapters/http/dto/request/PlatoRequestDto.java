package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoRequestDto {

    @NotBlank

    private String nombre;
    @NotBlank
    private Long precio;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlImagen;
    @NotBlank
    private String categoria;
    @NotBlank
    @OneToOne
    private RestauranteEntity restauranteEntity;








}
