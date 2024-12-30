package com.guincha.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Random;

@Document(collection = "pacientes")
public class Paciente implements Persona {
    
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nombre;
    private String email;
    private String cedula;
    private String celular;
    private int edad;

    public Paciente() {
        this.id = new Random().nextLong();
    }

    public Paciente(String nombre, String email, String cedula, String celular, int edad) {
        this.id = new Random().nextLong();
        this.nombre = nombre;
        this.email = email;
        this.cedula = cedula;
        this.celular = celular;
        this.edad = edad;
    }

   
  
    public Long getId() {
        return id;
    }

  
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCedula() {
        return cedula;
    }

    @Override
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCelular() {
        return celular;
    }

    @Override
    public void setCelular(String celular) {
        this.celular = celular;
    }

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
    
    
}
