package com.cibertec.paciente.service;

import org.springframework.stereotype.Service;

import com.cibertec.paciente.entity.Paciente;
import com.cibertec.paciente.repository.PacienteRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PacienteService {

	private final PacienteRepository repository;

	public PacienteService(PacienteRepository repository) {
		this.repository = repository;
	}

	public Flux<Paciente> listar() {
		return repository.findAll();
	}

	public Mono<Paciente> buscar(Long id) {
		return repository.findById(id);
	}

	public Mono<Paciente> guardar(Paciente paciente) {
		return repository.save(paciente);
	}
}