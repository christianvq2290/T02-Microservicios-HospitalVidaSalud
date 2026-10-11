package com.cibertec.cita.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cibertec.cita.dto.Paciente;
import com.cibertec.cita.entity.Cita;
import com.cibertec.cita.producer.CitaProducer;
import com.cibertec.cita.repository.CitaRepository;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CitaService {

    private final CitaRepository repository;
    private final WebClient.Builder webClientBuilder;
    private final CitaProducer producer;

    public CitaService(
            CitaRepository repository,
            WebClient.Builder webClientBuilder,
            CitaProducer producer) {

        this.repository = repository;
        this.webClientBuilder = webClientBuilder;
        this.producer = producer;
    }

    public Flux<Cita> listar() {
        return repository.findAll();
    }

    public Mono<Cita> buscar(Long id) {
        return repository.findById(id);
    }

    public Mono<Cita> guardar(Cita cita) {

        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/pacientes/"
                        + cita.getPacienteId())
                .retrieve()
                .bodyToMono(Paciente.class)
                .flatMap(paciente -> {

                    System.out.println(
                            "Paciente encontrado: "
                                    + paciente.getNombres());

                    if (cita.getEstado() == null) {
                        cita.setEstado("PENDIENTE");
                    }

                    return repository.save(cita)
                            .doOnSuccess(c ->
                                    producer.enviarEvento(
                                            "CITA_CONFIRMADA ID="
                                                    + c.getId()));
                });
    }
}