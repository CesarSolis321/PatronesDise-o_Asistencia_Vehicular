package com.patrones.asistencia_vehicular.models.servicios;

public class ServicioAdicional implements IServicio {
    protected IServicio visitaTecnica;

    public ServicioAdicional(IServicio visitaTecnica) {
        this.visitaTecnica = visitaTecnica;
    }

    @Override
    public String generarCodigoServicio() {
        return visitaTecnica.generarCodigoServicio();
    }
    
}
