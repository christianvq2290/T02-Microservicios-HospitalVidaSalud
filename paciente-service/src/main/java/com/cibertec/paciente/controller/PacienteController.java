package com.cibertec.paciente.controller;

import org.springframework.web.bind.annotation.*;

import com.cibertec.paciente.entity.Paciente;
import com.cibertec.paciente.service.PacienteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	private final PacienteService service;

	public PacienteController(PacienteService service) {
		this.service = service;
	}

	@GetMapping
	public Flux<Paciente> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Mono<Paciente> buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@PostMapping
	public Mono<Paciente> guardar(@RequestBody Paciente paciente) {
		return service.guardar(paciente);
	}
}