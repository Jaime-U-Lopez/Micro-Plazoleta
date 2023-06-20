package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioAutenticadoRequestDto {

    private Long id;
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;




}
