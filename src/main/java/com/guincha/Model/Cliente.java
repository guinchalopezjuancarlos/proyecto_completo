package com.guincha.Model;



import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection = "clientes")
public class Cliente implements Persona {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String nombre;
    private String cedula;
    private String email;
    private String celular;
    private String direccion;

    
    
    public Cliente() {
    	this.id = new Random().nextLong();
	}

    
	public Cliente( String nombre, String cedula, String email, String celular, String direccion) {
		this.id = new Random().nextLong();
		this.nombre = nombre;
		this.cedula = cedula;
		this.email = email;
		this.celular = celular;
		this.direccion = direccion;
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

  

    // Otros métodos específicos de Cliente
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
