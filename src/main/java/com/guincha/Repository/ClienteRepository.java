package com.guincha.Repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, Long> {
	   Optional<Cliente> findByCedula(String cedula);
}