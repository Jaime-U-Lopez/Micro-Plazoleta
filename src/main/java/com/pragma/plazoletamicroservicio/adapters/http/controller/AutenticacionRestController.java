package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.LoginRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.request.UsuarioAutenticadoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IUsuarioAutenticadoHandler;
import com.pragma.plazoletamicroservicio.adapters.http.mapper.IUsuarioAutenticadoRequestMapper;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticadoEntity;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.mapper.UsuarioAutenticadoEntityMapper;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import com.pragma.plazoletamicroservicio.configuration.FeignClient.UserHandlerFeing;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/aut/v1")
public class AutenticacionRestController {

    private IUsuarioAutenticadoHandler usuarioAutenticadoHandler;

    private UserHandlerFeing userHandlerFeing;

    public AutenticacionRestController(IUsuarioAutenticadoHandler usuarioAutenticadoHandler, UserHandlerFeing userHandlerFeing) {
        this.usuarioAutenticadoHandler = usuarioAutenticadoHandler;

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
    public ResponseEntity<Map<String, String>> saveUserAutenticacion(@RequestBody LoginRequestDto loginRequestDto ) {

        Optional<UsuarioAutenticadoRequestDto>    usuarioAutenticadoRequestDto=    userHandlerFeing.authenticacion(loginRequestDto);
        usuarioAutenticadoRequestDto.get().setId(1L);

        usuarioAutenticadoHandler.saveUser(usuarioAutenticadoRequestDto.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,"Usuario Creado con token: "+ usuarioAutenticadoRequestDto.get().getToken())
        );
    }




}
