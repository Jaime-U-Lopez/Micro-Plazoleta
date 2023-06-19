package com.pragma.plazoletamicroservicio.configuration.FeignClient;


import com.pragma.plazoletamicroservicio.adapters.http.dto.request.LoginRequestDto;
import com.pragma.plazoletamicroservicio.adapters.http.dto.response.PersonResponseDto;
import com.pragma.plazoletamicroservicio.adapters.jpa.mysql.entity.UsuarioAutenticado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "microservicio-users", url = "http://localhost:8090") // Ajusta la URL y el nombre del microservicio destino
public interface UserHandlerFeing {


    @GetMapping("user/owner/{id}")
    public Optional<PersonResponseDto> getOwner(@PathVariable("id") Long id);



    @PostMapping("auth/login")
    public Optional<UsuarioAutenticado> authenticacion(@RequestBody LoginRequestDto LoginRequestDto);



    @GetMapping("user/endpoint") // Endpoint en el Microservicio 2
    String getResponseFromMicroservicio2();




}
