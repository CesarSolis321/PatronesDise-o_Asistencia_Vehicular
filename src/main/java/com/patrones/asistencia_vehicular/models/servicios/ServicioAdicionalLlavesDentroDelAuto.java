package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicionalLlavesDentroDelAuto extends ServicioAdicional {
    private double costo;
    public ServicioAdicionalLlavesDentroDelAuto(IServicio visitaTecnica) {
        super(visitaTecnica);
        this.costo = 10;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio() + "+LL";
    }

}
