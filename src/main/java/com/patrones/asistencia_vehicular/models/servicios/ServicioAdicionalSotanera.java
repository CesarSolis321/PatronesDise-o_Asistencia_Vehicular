package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalSotanera extends ServicioAdicional {
    private double costo;
    public ServicioAdicionalSotanera(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 80;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+SO";
    }

}
