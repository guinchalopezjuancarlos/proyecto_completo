package com.guincha.Service;

import org.springframework.stereotype.Service;
import com.guincha.Model.Venta;
import com.guincha.Repository.VentaRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    private final VentaRepository repository;

    public VentaService(VentaRepository repository) {
        this.repository = repository;
    }

   
    public List<Venta> getAllVentas() {
        return repository.findAll();
    }

  
    public Optional<Venta> getVentaById(Long id) {
        return repository.findById(id);
    }

   
    public Venta saveVenta(Venta venta) {
       Optional<Venta> existing = repository.findById(venta.getId());
        if (existing.isPresent()) {
            Venta  existing2 = existing.get();
            
            existing2.setEstado(venta.getEstado());
           
            return repository.save(existing2);  
        } else {
            return repository.save(venta);
        }
    }
    
    public Venta updateVenta(Venta venta) {
        if (venta.getId() == null) {
            throw new IllegalArgumentException("The update request must include an ID");
        }
        Venta currentVenta = repository.findById(venta.getId()).orElseThrow();
        currentVenta.merge(venta);
        return repository.save(currentVenta);
    }
  
    public void deleteVenta(Long id) {
        repository.deleteById(id);
    }

 
 
   
    public List<Venta> getVentasByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return repository.findByFechaBetween(fechaInicio, fechaFin);
    }
}