package com.patrones.asistencia_vehicular.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.patrones.asistencia_vehicular.entities.UsuarioEntity;

import reactor.core.publisher.Mono;

public interface UsuarioRepository extends R2dbcRepository<UsuarioEntity,Long>{
    Mono<UsuarioEntity> findByEmail(String email);
}
