package com.guincha.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Document(collection = "ventas") 
public class Venta {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private  Long id; 
    @DBRef
    private Cliente cliente; 
    private String metodopago;
    private LocalDate fecha; 
    private double total; 
    private String estado;
 
    
    
    
	public Venta() {
		this.id = new Random().nextLong();
	}
	
	public Venta(String id, Cliente cliente, LocalDate fecha, double total,String metodospago,String estado) {
		this.id = new Random().nextLong();
		this.cliente = cliente;
		this.fecha = fecha;
		this.total = total;
		this.metodopago = metodospago;
		this.estado = estado;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	  public Venta merge(Venta updateRequest) {
		  Optional.ofNullable(updateRequest.getCliente()).ifPresent(this::setCliente);
	      Optional.ofNullable(updateRequest.getFecha()).ifPresent(this::setFecha);
	      Optional.ofNullable(updateRequest.getMetodopago()).ifPresent(this::setMetodopago);
	      Optional.ofNullable(updateRequest.getEstado()).ifPresent(this::setEstado);
	      Optional.ofNullable(updateRequest.getTotal()).ifPresent(this::setTotal);

	      return this;
	  }
	
    
}