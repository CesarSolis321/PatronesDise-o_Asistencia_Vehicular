package com.patrones.asistencia_vehicular.models.solicitud_usuario;

public class SolicitudUsuario {
    Long id;
    String idUsuario;
    String idSolicitud;
    String codigoServicio;
    double monto;
    
    public SolicitudUsuario() {
    }

    public SolicitudUsuario(Long id, String idUsuario, String idSolicitud, String codigoServicio, double monto) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idSolicitud = idSolicitud;
        this.codigoServicio = codigoServicio;
        this.monto = monto;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getIdSolicitud() {
        return idSolicitud;
    }


    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }


    public String getCodigoServicio() {
        return codigoServicio;
    }


    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
