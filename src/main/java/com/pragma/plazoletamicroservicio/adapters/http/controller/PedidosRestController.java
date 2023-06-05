package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PedidoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.RestauranteRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PedidoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IPedidoHandler;
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

    private final IPedidoHandler pedidoHandler;


    @Autowired
    public PedidosRestController(IPedidoHandler pedidoHandler) {
        this.pedidoHandler = pedidoHandler;
    }
    @Operation(summary = "Crear un nuevo Pedido ",
    responses = {
            @ApiResponse(responseCode = "201", description = "Creacion de Pedidos  ",
            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
            @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
    })
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> createPedido(@Valid @RequestBody PedidoRequestDto pedidoRequestDto){
        pedidoHandler.savePedido(pedidoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.PEDIDO_CREADO)
        );
    }

    @Operation(summary = "Mostrar  un  Pedido ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Mostrar de Pedido  ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })
    @GetMapping("/pedidos/{id}")
    public PedidoResponseDto getPedido (@PathVariable("id") Long id){
        return pedidoHandler.getPedido(id);
    }


    @Operation(summary = "Mostrar  todos los   pedidos  ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Mostrar todos los  Pedidos  ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "No hay pedidos ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
            })

    @GetMapping("/")
    public List<PedidoResponseDto> getAllPedidos(){
        return pedidoHandler.getAllPedidos();
    }




    @Operation(summary = "Elimine un pedido    ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Eliminar un pedido ",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Map<String, String>> deletePedido(@PathVariable("id") Long id ) {
        pedidoHandler.deletePedido(id);
        return ResponseEntity.ok(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.PEDIDO_ELIMINADO));
    }



}
