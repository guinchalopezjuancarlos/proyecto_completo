package com.guincha.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Random;

// Enum para definir los estados de la cita médica
enum EstadoCita {
    PENDIENTE, 
    DISPONIBLE, 
    ATENDIDO;
}

@Document(collection = "citasmedicas")
@Data
public class CitaMedica {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    
    @DBRef
    private Paciente paciente;

    @DBRef
    private Doctor doctor;
    
    private String fecha;

    private EstadoCita estado;  // Se usa el Enum EstadoCita

    private String horario;

    public CitaMedica() {
        this.id = new Random().nextLong();
    }

    public CitaMedica(Paciente paciente, Doctor doctor, String fecha, EstadoCita estado, String horario) {
        this.id = new Random().nextLong();
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.estado = estado;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
