package com.cibertec.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PacienteService1Application {

    public static void main(String[] args) {
        SpringApplication.run(
            PacienteService1Application.class,
            args
        );

        System.out.println("PACIENTE SERVICE INICIADO");
    }
}