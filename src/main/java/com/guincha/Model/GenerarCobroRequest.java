package com.guincha.Model;

import java.util.List;

public class GenerarCobroRequest {
    private String tnTelefono;
    private String tcRazonSocial;
    private String tcCiNit;
    private String tnMonto;
    private String tcCorreo;
    private int tnTipoServicio;
    private List<DetalleVenta> taPedidoDetalle;

	public GenerarCobroRequest() {
	
	}
	public String getTnTelefono() {
		return tnTelefono;
	}
	public void setTnTelefono(String tnTelefono) {
		this.tnTelefono = tnTelefono;
	}
	public String getTcRazonSocial() {
		return tcRazonSocial;
	}
	public void setTcRazonSocial(String tcRazonSocial) {
		this.tcRazonSocial = tcRazonSocial;
	}
	public String getTcCiNit() {
		return tcCiNit;
	}
	public void setTcCiNit(String tcCiNit) {
		this.tcCiNit = tcCiNit;
	}
	public String getTnMonto() {
		return tnMonto;
	}
	public void setTnMonto(String tnMonto) {
		this.tnMonto = tnMonto;
	}
	public String getTcCorreo() {
		return tcCorreo;
	}
	public void setTcCorreo(String tcCorreo) {
		this.tcCorreo = tcCorreo;
	}
	public int getTnTipoServicio() {
		return tnTipoServicio;
	}
	public void setTnTipoServicio(int tnTipoServicio) {
		this.tnTipoServicio = tnTipoServicio;
	}
	public List<DetalleVenta> getTaPedidoDetalle() {
		return taPedidoDetalle;
	}
	public void setTaPedidoDetalle(List<DetalleVenta> taPedidoDetalle) {
		this.taPedidoDetalle = taPedidoDetalle;
	}

 
}