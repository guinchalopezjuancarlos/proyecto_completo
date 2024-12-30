package com.guincha.Service;

import org.springframework.stereotype.Service;

import com.guincha.Model.Medicamento;
import com.guincha.Repository.MedicamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repository;

    public MedicamentoService(MedicamentoRepository repository) {
        this.repository = repository;
    }

    public List<Medicamento> getAllMedicamentos() {
        return repository.findAll();
    }

    public Optional<Medicamento> getMedicamentoById(Long id) {
        return repository.findById(id);
    }

    public Medicamento saveMedicamento(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    public void deleteMedicamento(Long id) {
        repository.deleteById(id);
    }

    public List<Medicamento> searchMedicamentosByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}
