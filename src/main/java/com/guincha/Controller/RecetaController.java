package com.guincha.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guincha.Model.Receta;
import com.guincha.Service.RecetaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas") 
public class RecetaController {

    private final RecetaService service;

    public RecetaController(RecetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Receta> getAllRecetas() {
        return service.getAllRecetas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Long id) {
        Optional<Receta> receta = service.getRecetaById(id);
        return receta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public Receta saveReceta(@RequestBody Receta receta) {
        return service.saveReceta(receta);
    }

    @DeleteMapping("/{id}")
    public void deleteReceta(@PathVariable Long id) {
        service.deleteReceta(id);
    }

  
  

  
}