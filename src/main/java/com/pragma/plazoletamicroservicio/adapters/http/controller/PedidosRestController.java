package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IRestauranteHandler;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/apiPedidos/v1")
public class PedidosRestController {

    private final IRestauranteHandler restauranteHandler;


    @Autowired
    public PedidosRestController(IRestauranteHandler restauranteHandler) {
        this.restauranteHandler = restauranteHandler;
    }
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
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.RESTAURANTE_CREADO_MENSAJE)
        );
    }

    @Operation(summary = "Mostrar  un  Restaurante ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Creacion de Restaurantes  ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/pedidos/{id}")
    public RestauranteResponseDto getRestaurante (@PathVariable("id") Long id){
        return restauranteHandler.getRestaurante(id);
    }


    @Operation(summary = "Mostrar  todos los   Restaurante ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Creacion de Restaurantes  ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })

    @GetMapping("/")
    public List<RestauranteResponseDto> getAllRestaurantes(){
        return restauranteHandler.getAllRestauntes();
    }




    @Operation(summary = "Elimine un restaurante  ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Map<String, String>> deleteRestaurante(@PathVariable("id") Long id ) {
        restauranteHandler.deleteRestaurante(id);
        return ResponseEntity.ok(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.RESTAURANTE_ELIMINADO_CON_EXITO));
    }



}
