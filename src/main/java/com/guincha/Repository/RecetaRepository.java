package com.guincha.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Receta;


public interface RecetaRepository extends MongoRepository<Receta, Long> {
   


   
}