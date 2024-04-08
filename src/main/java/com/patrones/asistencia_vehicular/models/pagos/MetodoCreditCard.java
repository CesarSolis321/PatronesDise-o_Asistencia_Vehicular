package com.patrones.asistencia_vehicular.models.pagos;

public class MetodoCreditCard  implements IStrategyMetodoPago{

    @Override
    public Boolean Pagar(double monto) {
        System.out.println("se pago con tarjeta de credito el monto: "+ monto);
        return true;
    }
    
}