package com.guincha.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guincha.Model.Medicamento;
import com.guincha.Service.MedicamentoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicamentos") 
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

 
    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return service.getAllMedicamentos();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicationById(@PathVariable Long id) {
        Optional<Medicamento> medication = service.getMedicamentoById(id);
        return medication.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Medicamento saveMedicamento(@RequestBody Medicamento medicamento) {
        return service.saveMedicamento(medicamento);
    }

    @DeleteMapping("/{id}")
    public void deleteMedicamento(@PathVariable Long id) {
        service.deleteMedicamento(id);
    }

  
    @GetMapping("/search")
    public List<Medicamento> searchMedicamentosByNombre(@RequestParam String nombre) {
        return service.searchMedicamentosByNombre(nombre);
    }
}