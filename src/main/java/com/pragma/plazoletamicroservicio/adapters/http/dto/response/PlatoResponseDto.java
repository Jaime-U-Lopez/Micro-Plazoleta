package com.pragma.plazoletamicroservicio.adapters.http.dto.response;

import com.pragma.plazoletamicroservicio.domain.model.Restaurante;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlatoResponseDto {
    private String nombre;
    private Long precio;
    private String descripcion;
    private String urlImagen;
    private String categoria;

    private Restaurante restaurante;
    private boolean estado= true;
}