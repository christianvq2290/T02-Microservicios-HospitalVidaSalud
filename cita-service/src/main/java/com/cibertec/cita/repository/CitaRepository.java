package com.cibertec.cita.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cibertec.cita.entity.Cita;

public interface CitaRepository extends ReactiveCrudRepository<Cita, Long>{

}