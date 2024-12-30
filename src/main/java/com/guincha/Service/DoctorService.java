package com.guincha.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guincha.Model.Doctor;
import com.guincha.Repository.DoctorRepository;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository repository) {
        this.doctorRepository = repository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor saveDoctor(Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findByCedula(doctor.getCedula());
        if (existingDoctor.isPresent()) {
            Doctor existing = existingDoctor.get();
            existing.setNombre(doctor.getNombre());
            existing.setEmail(doctor.getEmail());
            existing.setCelular(doctor.getCelular());
            return doctorRepository.save(existing);  
        } else {
            return doctorRepository.save(doctor);
        }
    }

    public void deleteDoctor(Long id) {
    	doctorRepository.deleteById(id);
    }
}