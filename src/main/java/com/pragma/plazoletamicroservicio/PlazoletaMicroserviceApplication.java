package com.pragma.plazoletamicroservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//sss
@SpringBootApplication()
@EnableFeignClients
public class PlazoletaMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlazoletaMicroserviceApplication.class, args);
    }

}
