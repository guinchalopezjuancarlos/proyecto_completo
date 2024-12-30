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

import com.guincha.Model.Pago;
import com.guincha.Service.PagoService;

@RestController
@RequestMapping("/api/pagos") 
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

  
    @GetMapping
    public List<Pago> getAllPagos() {
        return service.getAllPagos();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        Optional<Pago> pago = service.getPagoById(id);
        return pago.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

 
    @PostMapping
    public Pago savePago(@RequestBody Pago pago) {
        return service.savePago(pago);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        Optional<Pago> pago = service.getPagoById(id);
        if (pago.isPresent()) {
            service.deletePago(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
