package com.pragma.plazoletamicroservicio.configuration.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservicio-user", url = "http://localhost:8090") // Ajusta la URL y el nombre del microservicio destino
public interface UserFeignClient {

    @GetMapping("/user/provider/{id}") // Ajusta la ruta del endpoint
    ResponseEntity<RespuestaDTO> obtenerDatos(); // Ajusta el tipo de respuesta esperada

}
