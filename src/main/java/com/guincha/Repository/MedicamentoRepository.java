package com.guincha.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Medicamento;

public interface MedicamentoRepository extends MongoRepository<Medicamento, Long> {
	  List<Medicamento> findByNombre(String nombre);
}
