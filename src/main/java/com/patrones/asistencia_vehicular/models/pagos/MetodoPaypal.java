package com.patrones.asistencia_vehicular.models.pagos;

public class MetodoPaypal implements IStrategyMetodoPago{

    @Override
    public Boolean Pagar(double monto) {
        System.out.println("se pago por paypal el monto: " + monto);
        return true;
    }
    
}
