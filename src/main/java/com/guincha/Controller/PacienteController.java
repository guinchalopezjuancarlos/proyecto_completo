package com.guincha.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guincha.Model.Paciente;
import com.guincha.Service.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return service.getAllPacientes();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> getPacieneById(@PathVariable Long id) {
        return service.getPacienteById(id);
    }

    @PostMapping
    public Paciente savePaciente(@RequestBody Paciente paciente) {
        return service.savePaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        service.deletePaciente(id);
    }
}