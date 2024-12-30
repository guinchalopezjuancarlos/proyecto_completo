package com.guincha.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guincha.Model.CitaMedica;
import com.guincha.Service.CitaMedicaService;

@RestController
@RequestMapping("/api/citasmedicas") 
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

   
    @GetMapping
    public List<CitaMedica> getAllCitasMedicas() {
        return service.getAllCitasMedicas();
    }

 
    @GetMapping("/{id}")
    public ResponseEntity<CitaMedica> getCitaMedicatById(@PathVariable Long id) {
        Optional<CitaMedica> appointment = service.getCitaMedicaById(id);
        return appointment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

  
    @PostMapping
    public CitaMedica saveCitaMedica(@RequestBody CitaMedica citamedica) {
        return service.saveCitaMedica(citamedica);
    }

    @DeleteMapping("/{id}")
    public void deleteCitaMedica(@PathVariable Long id) {
        service.deleteCitaMedica(id);
    }

   
}