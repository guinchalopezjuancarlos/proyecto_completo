package com.guincha.Model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Document(collection = "doctors")
@Data
public class Doctor implements Persona{
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nombre;
    private String cedula;
    private String celular;
    private String email;
    private String especialidad;
    
    
	public Doctor() {
		this.id = new Random().nextLong();
	}


	public Doctor( String nombre, String cedula, String celular,String email, String especialidad) {
		
		this.id = new Random().nextLong();
		this.nombre = nombre;
		this.cedula = cedula;
		this.celular = celular;
		this.email = email;
		this.especialidad = especialidad;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
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
    
    
}
