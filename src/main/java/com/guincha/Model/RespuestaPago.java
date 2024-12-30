package com.guincha.Model;
public class RespuestaPago {
    private String qrCode;
    private String mensaje;
    private String nroTransaccion;
    private boolean exito;

  
    public RespuestaPago(String qrCode, String mensaje, String nroTransaccion, boolean exito) {
        this.qrCode = qrCode;
        this.mensaje = mensaje;
        this.nroTransaccion = nroTransaccion;
        this.exito = exito;
    }

    // Getters y Setters
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNroTransaccion() {
        return nroTransaccion;
    }

    public void setNroTransaccion(String nroTransaccion) {
        this.nroTransaccion = nroTransaccion;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
}
