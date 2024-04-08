package com.patrones.asistencia_vehicular.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.asistencia_vehicular.entities.SolicitudEntity;
import com.patrones.asistencia_vehicular.models.solicitud.BuilderSolicitud;
import com.patrones.asistencia_vehicular.models.solicitud.Solicitud;
import com.patrones.asistencia_vehicular.repositories.SolicitudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository SolicitudRepository;

    private Solicitud solicitudActual;

    public Mono<Solicitud> crearSolicitud(Map<String, Object> body){

        BuilderSolicitud solicitudBuilder = new BuilderSolicitud(body.get("nombreCliente").toString(), body.get("apellidoCliente").toString(), body.get("telefono").toString(), body.get("ubicacion").toString());

        if (body.get("fecha")!=null)    {

            solicitudBuilder.withFecha( body.get("fecha").toString());
        }

        if (body.get("modeloCarro")!=null)    {

            solicitudBuilder.withModeloCarro( body.get("modeloCarro").toString());
        }

        if (body.get("descripcion")!=null)    {

            solicitudBuilder.withDescripcion( body.get("descripcion").toString());
        }

        solicitudActual = solicitudBuilder.build();
        solicitudActual.notificar("Se creo una nueva solicitud!");

        //return  Mono.just(solicitudActual);
        SolicitudEntity solicitudEntity = SolicitudEntity.fromDomainModel( solicitudActual );
        return Mono.just( SolicitudRepository.save(solicitudEntity).doOnSuccess(pl -> {}).block().toDomainModel() );
    }

    public Flux<Solicitud> mostrarTodasLasSolicitudes() {
        return SolicitudRepository.findAll().flatMap(SolicitudEntity::toDomainModelMono);
    }
}
