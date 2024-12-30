package com.guincha.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Pago;


public interface PagoRepository extends MongoRepository<Pago, Long> {
}