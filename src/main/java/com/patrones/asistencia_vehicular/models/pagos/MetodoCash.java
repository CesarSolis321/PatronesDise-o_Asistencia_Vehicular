package com.patrones.asistencia_vehicular.models.pagos;

public class MetodoCash  implements IStrategyMetodoPago{

    @Override
    public Boolean Pagar(double monto) {
        System.out.println("se pago en efectivo el monto: " + monto);
        return true;
    }
    
}