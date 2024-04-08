package com.patrones.asistencia_vehicular.utils;

import com.patrones.asistencia_vehicular.models.solicitud.Solicitud;

public interface IObservador {
    public void notificarSolicitudCreada(String cambiosRealizados, Solicitud solicitud);
}
