package com.patrones.asistencia_vehicular.models.user;

import com.patrones.asistencia_vehicular.models.solicitud.Solicitud;
import com.patrones.asistencia_vehicular.utils.IObservador;

public class Tecnico extends Usuario implements IObservador{
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Tecnico(Long id, String nombre, String apellido, String email, String telefono, String estado) {
        super(id, nombre, apellido, email, telefono);
        this.estado = estado;
    }

    @Override
    public void notificarSolicitudCreada(String cambiosRealizados, Solicitud solicitud) {
        
        System.out.println("userid: " + super.getId() + " → "+super.getNombre()+ " " + cambiosRealizados + " \n" + solicitud);
    }
    
}
