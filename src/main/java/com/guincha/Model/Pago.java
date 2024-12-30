package com.guincha.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document(collection = "pagos") 
public class Pago {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    @DBRef
    private Paciente paciente; 

    private LocalDateTime fechapago; 
    private String metodopago;
    private String estado;
    private String tipoConsulta;
    private Long montoTotal;

    // Constructor por defecto
    public Pago() {
        this.id = UUID.randomUUID().toString(); // Genera un UUID único
    }

    // Constructor con parámetros
    public Pago(String id, LocalDateTime fechapago, Paciente paciente ,String metodopago, String estado, String tipoConsulta, Long montoTotal) {
        this.id = id != null ? id : UUID.randomUUID().toString(); // Usa el id pasado o genera uno nuevo
		this.paciente = paciente;
        this.fechapago = fechapago;
        this.metodopago = metodopago;
        this.estado = estado;
        this.tipoConsulta = tipoConsulta;
        this.montoTotal = montoTotal;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
	public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechapago() {
        return fechapago;
    }

    public void setFechapago(LocalDateTime fechapago) {
        this.fechapago = fechapago;
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

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Long getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Long montoTotal) {
        this.montoTotal = montoTotal;
    }
}
