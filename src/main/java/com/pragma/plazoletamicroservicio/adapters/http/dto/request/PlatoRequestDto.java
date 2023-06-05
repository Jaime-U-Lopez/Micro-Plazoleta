package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.RestauranteEntity;
import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatoRequestDto {

    @NotBlank
    private String nombre;
    @Positive(message = "El precio  debe ser positivo y mayor a cero")
    private Long precio;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String urlImagen;
    @NotBlank
    private String categoria;

   // private RestauranteEntity RestauranteEntity;
    //@Positive(message = "El id   debe ser positivo y mayor a cero")
    private Restaurante restaurante ;







}
