package com.guincha.Model;


import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Document(collection = "medicamentos") // Define la colección de MongoDB
@Data
public class Medicamento {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nombre; 
    private Double precio;
    private int stock; 
    private String descripcion;
    
public Medicamento() {
		this.id = new Random().nextLong();
	}
    
	public Medicamento(String nombre, Double precio, int stock, String descripcion) {
		
		this.id = new Random().nextLong();
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
    
	
    
}