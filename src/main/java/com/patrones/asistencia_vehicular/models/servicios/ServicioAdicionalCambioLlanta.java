package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalCambioLlanta extends ServicioAdicional {
    private double costo;
    public ServicioAdicionalCambioLlanta(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 20;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+CL";
    }

}
