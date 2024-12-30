package com.guincha.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Venta;

import java.time.LocalDateTime;
import java.util.List;

public interface VentaRepository extends MongoRepository<Venta, Long> {

  
    List<Venta> findByFechaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}