package com.guincha.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guincha.Model.Paciente;
import com.guincha.Repository.PacienteRepository;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> getAllPacientes() {
        return repository.findAll();
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return repository.findById(id);
    }

    public Paciente savePaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public void deletePaciente(Long id) {
        repository.deleteById(id);
    }
}