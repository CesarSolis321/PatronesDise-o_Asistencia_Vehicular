package com.patrones.asistencia_vehicular.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.patrones.asistencia_vehicular.models.solicitud_usuario.SolicitudUsuario;

import reactor.core.publisher.Mono;

@Table("solicitud_usuario")
public class SolicitudUsuarioEntity {
    @Id
    Long id;
    String idUsuario;
    String idSolicitud;
    String codigoServicio;
    double monto;


    public SolicitudUsuarioEntity(Long id, String idUsuario, String idSolicitud, String codigoServicio, double monto) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idSolicitud = idSolicitud;
        this.codigoServicio = codigoServicio;
        this.monto = monto;
    }

    public static SolicitudUsuarioEntity fromDomainModel( SolicitudUsuario solicitudUsuario ) {
        return new SolicitudUsuarioEntity( null,solicitudUsuario.getIdUsuario(), solicitudUsuario.getIdSolicitud(), solicitudUsuario.getCodigoServicio() , solicitudUsuario.getMonto() );
    }

    public SolicitudUsuario toDomainModel()  {

        return new SolicitudUsuario(id, idUsuario,idSolicitud,codigoServicio,monto);
    }

    public Mono<SolicitudUsuario> toDomainModelMono()  {

        return Mono.just(new SolicitudUsuario(id, idUsuario,idSolicitud,codigoServicio,monto));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


}
