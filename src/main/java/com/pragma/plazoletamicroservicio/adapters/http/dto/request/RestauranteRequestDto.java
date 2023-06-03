package com.pragma.plazoletamicroservicio.adapters.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranteRequestDto {


    @NotBlank
    @Positive(message = "El numero de documento no puede ser negativo.")
    private Long idPropietario;
    @NotBlank
    private String   nombre;

    @Pattern(message = "El numero de documento debe ser solo numerico.", regexp = "^[0-9]+$")
    @Positive(message = "El numero de documento no puede ser negativo.")
    private Long nit;

    @NotBlank
    private String direccion;


    @NotBlank
    @Pattern(regexp = "^(\\+\\d{1,3})?((\\d{1,3})|\\d{1,3})\\d{3,4}\\d{4}$", message = "el numero de celular debe tener el formato correcto.")
    @Size(min = 6, max = 13, message = "El numero de celular debe tener entre 6 y 13 digitos.")
    @Positive(message = "El numero de celular no puede ser negativo")
    private int telefono;

    @NotBlank
    private String UrlLogo;


}
