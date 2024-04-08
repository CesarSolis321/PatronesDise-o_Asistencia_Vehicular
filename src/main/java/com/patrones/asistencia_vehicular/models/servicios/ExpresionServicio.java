package com.patrones.asistencia_vehicular.models.servicios;

import java.util.HashMap;
import java.util.Map;

public class ExpresionServicio implements IExpresion {
    private String servicio;
    private Map<String, Double>  costo;

    public ExpresionServicio(String servicio) {
        this.servicio = servicio;
        this.costo = new HashMap<>();
        costo.put("TB", 50.0);
        costo.put("CL", 60.0);
        costo.put("LL", 70.0);
        costo.put("RE", 80.0);
        costo.put("RS", 90.0);
        costo.put("SO", 100.0);
    }

    @Override
    public double interpretar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'interpretar'");
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Double getCosto() {
        return costo.get(servicio);
    }

    
}
