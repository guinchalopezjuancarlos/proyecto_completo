package com.guincha.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.CitaMedica;


public interface CitaMedicaRepository extends MongoRepository<CitaMedica, Long> {
  
}