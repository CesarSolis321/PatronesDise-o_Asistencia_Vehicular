package com.patrones.asistencia_vehicular.models.servicios;

import java.util.HashMap;
import java.util.Map;

public class InterpreterContexto {
    private Map<String, Double> variables;

    public InterpreterContexto(String codigo) {
        this.variables = new HashMap<>();
    }

    public void setVariable(String variable, double value) {
        variables.put(variable, value);
    }

    public double getVariable(String variable) {
        return variables.getOrDefault(variable, 0.0);
    }
}
