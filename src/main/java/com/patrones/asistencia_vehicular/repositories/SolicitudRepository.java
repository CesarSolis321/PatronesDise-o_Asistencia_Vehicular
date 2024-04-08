package com.patrones.asistencia_vehicular.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.patrones.asistencia_vehicular.entities.SolicitudEntity;

public interface SolicitudRepository extends R2dbcRepository<SolicitudEntity,Long>{
    
}
