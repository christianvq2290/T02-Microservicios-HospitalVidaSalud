package com.cibertec.paciente.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cibertec.paciente.entity.Paciente;

public interface PacienteRepository
		extends ReactiveCrudRepository<Paciente, Long> {

}