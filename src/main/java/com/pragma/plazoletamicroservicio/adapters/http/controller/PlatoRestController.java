package com.pragma.plazoletamicroservicio.adapters.http.controller;

import com.pragma.plazoletamicroservicio.adapters.http.dto.request.PlatoRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PlatoResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.RestauranteResponseDto;
import com.pragma.plazoletamicroservicio.adapters.http.handlers.IPlatoHandler;
import com.pragma.plazoletamicroservicio.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plato/v1")
@RequiredArgsConstructor
//@SecurityRequirement(name = "jwt")
public class PlatoRestController {
    private  IPlatoHandler platoHandler;


    @Operation(summary = "mostrar todos los roles ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RestauranteResponseDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/")
    public ResponseEntity<List<PlatoResponseDto>> getAllRestaurantes() {
        return ResponseEntity.ok(platoHandler.getAllPlatos());
    }

    @Operation(summary = "Get all the roles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RestauranteResponseDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/")
    public ResponseEntity<Map<String, String>>  createPlato(@Valid @RequestBody PlatoRequestDto requestDto ) {
   platoHandler.savePlato(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.ROL_CREADO_CON_EXITO)
        );
    }


    @Operation(summary = "Elimine un rol ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})

    @DeleteMapping("")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody PlatoResponseDto platoResponseDto) {
       platoHandler.deletePlato(platoResponseDto);
        return ResponseEntity.ok(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.ROL_ELIMINADO_CON_EXITO));
    }



}
