package com.guincha.Service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.guincha.Model.Pago;
import com.guincha.Repository.PagoRepository;

@Service
public class PagoService {
    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public List<Pago> getAllPagos() {
        return repository.findAll();
    }

    public Optional<Pago> getPagoById(Long id) {
        return repository.findById(id);
    }

    public Pago savePago(Pago pago) {
        return repository.save(pago);
    }

    public void deletePago(Long id) {
        repository.deleteById(id);
    }
}