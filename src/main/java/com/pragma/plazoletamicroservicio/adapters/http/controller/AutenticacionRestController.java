package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.LoginRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PedidoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PedidoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PersonResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IPedidoHandler;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticado;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.ExceptionUserRequest;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.UserHandlerFeing;
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
import java.util.Optional;

@RestController
@RequestMapping("/aut/v1")
public class AutenticacionRestController {


    private UserHandlerFeing userHandlerFeing;

    @Autowired
    public AutenticacionRestController(UserHandlerFeing userHandlerFeing) {
        this.userHandlerFeing = userHandlerFeing;
    }

    @Operation(summary = "Autenticacion de user",
    responses = {
            @ApiResponse(responseCode = "201", description = "Creacion de Pedidos  ",
            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
            @ApiResponse(responseCode = "409", description = "Restaurante ya existente",
                    content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))
    })
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> autenticacion(@RequestBody LoginRequestDto loginRequestDto ){


        Optional<UsuarioAutenticado> response = userHandlerFeing.authenticacion(loginRequestDto);


        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,response.get().getToken())
        );
    }




}
