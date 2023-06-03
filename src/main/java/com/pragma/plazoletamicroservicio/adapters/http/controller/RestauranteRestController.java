package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IRestauranteHandler;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/apiUser/v1")
@RequiredArgsConstructor

public class RestauranteRestController {

    private  IRestauranteHandler restauranteHandler;


    @Operation(summary = "Crear un nuevo Restaurante ",
    responses = {
            @ApiResponse(responseCode = "201", description = "Creacion de Restaurantes  ",
            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
            @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
    })
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> createRestaurante(@Valid @RequestBody RestauranteRequestDto restauranteRequestDto){
        restauranteHandler.saveRestaurante(restauranteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.PROPIETARIO_CREADO_MENSAJE)
        );
    }

    @GetMapping("/usuarios/{id}")
    public Boolean validarRolPropietario(@PathVariable("id") Long id){
        return restauranteHandler.validarUser(id);
    }



    @Operation(summary = "Elimine un usuario ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody RestauranteRequestDto usuarioRequestDto) {
        restauranteHandler.deleteRestaurante(usuarioRequestDto);
        return ResponseEntity.ok(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USUARIO_ELIMINADO_CON_EXITO));
    }



}
