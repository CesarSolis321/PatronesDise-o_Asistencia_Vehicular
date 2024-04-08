package com.patrones.asistencia_vehicular.models.user;

import com.patrones.asistencia_vehicular.models.pagos.IStrategyMetodoPago;

public class Cliente extends Usuario{

    private IStrategyMetodoPago metodoPago;

    //private CreditCard creditcard;
    public Cliente(Long id, String nombre, String apellido, String email, String telefono) {
        super(id, nombre, apellido, email, telefono);
    }
    
    public IStrategyMetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(IStrategyMetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public boolean realizarPago(double monto){
        return metodoPago.Pagar(monto);
    }
}
