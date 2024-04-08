package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalRemolque extends ServicioAdicional {
    private double costo;
    public ServicioAdicionalRemolque(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 200;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+RE";
    }

}
