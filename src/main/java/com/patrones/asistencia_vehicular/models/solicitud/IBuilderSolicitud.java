package com.patrones.asistencia_vehicular.models.solicitud;

public interface IBuilderSolicitud {
    
    public IBuilderSolicitud withFecha(String fecha);
    public IBuilderSolicitud withModeloCarro(String modeloCarro);
    public IBuilderSolicitud withDescripcion(String descripcion);
}
