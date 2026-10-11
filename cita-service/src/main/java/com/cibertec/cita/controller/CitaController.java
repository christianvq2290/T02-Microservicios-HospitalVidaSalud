package com.cibertec.cita.controller;

import org.springframework.web.bind.annotation.*;

import com.cibertec.cita.entity.Cita;
import com.cibertec.cita.service.CitaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

	private final CitaService service;

	public CitaController(CitaService service) {
		this.service = service;
	}

	@GetMapping
	public Flux<Cita> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public Mono<Cita> buscar(@PathVariable Long id) {
		return service.buscar(id);
	}

	@PostMapping
	public Mono<Cita> guardar(@RequestBody Cita cita) {

	    System.out.println("CITA RECIBIDA: " + cita);

	    return service.guardar(cita);
	}
}