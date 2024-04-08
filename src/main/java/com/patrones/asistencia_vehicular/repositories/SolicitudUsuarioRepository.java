package com.patrones.asistencia_vehicular.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.patrones.asistencia_vehicular.entities.SolicitudUsuarioEntity;

public interface SolicitudUsuarioRepository extends R2dbcRepository<SolicitudUsuarioEntity,Long> {
    
}
