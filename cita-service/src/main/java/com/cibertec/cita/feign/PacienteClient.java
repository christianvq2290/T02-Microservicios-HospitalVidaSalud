package com.cibertec.cita.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cibertec.cita.dto.Paciente;

@FeignClient(name = "PACIENTE-SERVICE")
public interface PacienteClient {

    @GetMapping("/api/pacientes/{id}")
    Paciente buscarPaciente(@PathVariable Long id);

}