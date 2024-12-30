package com.guincha.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detallesventas") 
public class DetalleVenta {
	@Id
    private String productoId; 
    private String descripcion; 
    private int cantidad;
    private double precioUnitario; 
    private double subtotal; // Subtotal = cantidad * precioUnitario
    
    
	public DetalleVenta() {
	
	}


	public String getProductoId() {
		return productoId;
	}


	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
    
    
}
