package com.guincha.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Paciente;

public interface PacienteRepository extends MongoRepository<Paciente, Long> {
}