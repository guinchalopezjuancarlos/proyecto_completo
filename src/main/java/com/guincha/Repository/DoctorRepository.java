package com.guincha.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.guincha.Model.Doctor;


public interface DoctorRepository extends MongoRepository<Doctor, Long> {
	   Optional<Doctor> findByCedula(String cedula);
}