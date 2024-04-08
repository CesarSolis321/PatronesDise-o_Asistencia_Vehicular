package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioTecnicoBase implements IServicio {
    private double costo;
    public ServicioTecnicoBase(){
        this.costo = 50;
    }

    @Override
    public String generarCodigoServicio() {
        return "+TB";
    }
    
}
