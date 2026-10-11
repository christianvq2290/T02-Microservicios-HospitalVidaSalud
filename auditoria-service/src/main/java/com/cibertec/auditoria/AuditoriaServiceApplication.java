package com.cibertec.auditoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuditoriaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                AuditoriaServiceApplication.class,
                args);

        System.out.println(
                "AUDITORIA SERVICE INICIADO");
    }
}
