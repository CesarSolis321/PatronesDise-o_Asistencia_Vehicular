package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalAbastecimientoCombustible extends ServicioAdicional {
    private double costo;
    
    public ServicioAdicionalAbastecimientoCombustible(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 50;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+AC";
    }
    
}

