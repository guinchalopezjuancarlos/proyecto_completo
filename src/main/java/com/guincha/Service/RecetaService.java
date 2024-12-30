package com.guincha.Service;

import org.springframework.stereotype.Service;

import com.guincha.Model.Receta;
import com.guincha.Repository.RecetaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository repository;

    public RecetaService(RecetaRepository repository) {
        this.repository = repository;
    }

    public List<Receta> getAllRecetas() {
        return repository.findAll();
    }

    public Optional<Receta> getRecetaById(Long id) {
        return repository.findById(id);
    }

    public Receta saveReceta(Receta receta) {
        return repository.save(receta);
    }

    public void deleteReceta(Long id) {
        repository.deleteById(id);
    }

 

 

   
}