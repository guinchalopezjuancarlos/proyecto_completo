package com.guincha.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guincha.Model.CitaMedica;
import com.guincha.Repository.CitaMedicaRepository;

@Service
public class CitaMedicaService {
    private final CitaMedicaRepository repository;

    public CitaMedicaService(CitaMedicaRepository repository) {
        this.repository = repository;
    }

    public List<CitaMedica> getAllCitasMedicas() {
        return repository.findAll();
    }

    public Optional<CitaMedica> getCitaMedicaById(Long id) {
        return repository.findById(id);
    }
   
    public CitaMedica saveCitaMedica(CitaMedica citamedica) {
        return repository.save(citamedica);
    }

    public void deleteCitaMedica(Long id) {
        repository.deleteById(id);
    }
}