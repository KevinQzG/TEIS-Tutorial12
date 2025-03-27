package com.eafit.tutorial12;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API de Productos", version = "1.0", description = "Documentación de la API REST desarrollada en el Tutorial 12 con Spring Boot"), servers = @Server(url = "http://localhost:8080"))
@SpringBootApplication
public class Tutorial12Application {

    public static void main(String[] args) {
        SpringApplication.run(Tutorial12Application.class, args);
    }

}
