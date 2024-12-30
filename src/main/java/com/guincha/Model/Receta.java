package com.guincha.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;


import java.util.Random;

@Document(collection = "recetas")
@Data
public class Receta {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id; 

    @DBRef
    private Doctor doctor; 

    @DBRef
    private Paciente paciente; 

    private String fecha; 
    private String tratamiento; 
    private String medicamentosRecetados; // Nuevo atributo

    // Constructor vacío para MongoDB
    public Receta() {
        this.id = new Random().nextLong();
    }

    // Constructor con todos los parámetros
    public Receta(Long id, Doctor doctor, Paciente paciente, String fecha, String tratamiento,String medicamentosRecetados) {
        this.id = new Random().nextLong();
        this.doctor = doctor;
        this.paciente = paciente;
        this.fecha = fecha;
        this.tratamiento = tratamiento;
        this.medicamentosRecetados = medicamentosRecetados; // Asignar medicamentos recetados
    }

    // Métodos getter y setter para medicamentosRecetados
    public String getMedicamentosRecetados() {
        return medicamentosRecetados;
    }

    public void setMedicamentosRecetados(String medicamentosRecetados) {
        this.medicamentosRecetados = medicamentosRecetados;
    }

    // Otros getters y setters si es necesario

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}
