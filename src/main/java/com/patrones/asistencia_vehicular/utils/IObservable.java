package com.patrones.asistencia_vehicular.utils;

public interface IObservable {
    public void agregarObservador(IObservador observador);
    public void quitarObservador(IObservador observador);
}
