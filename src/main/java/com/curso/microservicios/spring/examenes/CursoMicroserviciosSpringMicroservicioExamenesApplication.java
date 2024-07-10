package com.curso.microservicios.spring.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.github.cdimascio.dotenv.Dotenv;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.curso.microservicios.spring.generic.examenes.models.entity"})
public class CursoMicroserviciosSpringMicroservicioExamenesApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
		SpringApplication.run(CursoMicroserviciosSpringMicroservicioExamenesApplication.class, args);
	}

}
