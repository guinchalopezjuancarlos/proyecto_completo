package com.guincha.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.guincha.Model.Venta;
import com.guincha.Service.VentaService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas") 
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

  
    @GetMapping
    public List<Venta> getAllVentas() {
        return service.getAllVentas();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        Optional<Venta> venta = service.getVentaById(id);
        return venta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

  
    @PostMapping
    public Venta saveVenta(@RequestBody Venta venta) {
        return service.saveVenta(venta);
    }
    
    @PostMapping("/update")
    public Venta updateVenta(@RequestBody Venta venta) {
        return service.updateVenta(venta);
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        Optional<Venta> venta = service.getVentaById(id);
        if (venta.isPresent()) {
            service.deleteVenta(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

 

    // Buscar ventas por rango de fechas
    @GetMapping("/fechas")
    public List<Venta> getVentasByFechaBetween(@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin) {
        return service.getVentasByFechaBetween(fechaInicio, fechaFin);
    }
}
