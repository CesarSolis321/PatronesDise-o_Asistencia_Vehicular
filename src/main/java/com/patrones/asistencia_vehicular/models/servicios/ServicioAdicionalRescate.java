package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalRescate  extends ServicioAdicional {
    private double costo;
    public ServicioAdicionalRescate(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 100;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+RS";
    }

}
