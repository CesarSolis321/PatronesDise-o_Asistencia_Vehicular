package com.patrones.asistencia_vehicular.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.asistencia_vehicular.entities.UsuarioEntity;
import com.patrones.asistencia_vehicular.models.user.Cliente;
import com.patrones.asistencia_vehicular.models.user.Tecnico;
import com.patrones.asistencia_vehicular.models.user.Usuario;
import com.patrones.asistencia_vehicular.repositories.UsuarioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Flux<Usuario> getAllUsers(){
       // return usuarioRepository.findAll().flatMap(UsuarioEntity::toDomainModelMono);
       return null;
    }
    public Mono<Usuario> registrarUsuarioCliente(Map<String, Object> body) {

        Cliente nuevo = new Cliente(null,body.get("nombre").toString(), body.get("apellido").toString(), body.get("email").toString(), body.get("telefono").toString());
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel( nuevo ); 
        return Mono.just( usuarioRepository.save(usuarioEntity).doOnSuccess(pl -> {}).block().toDomainModel() );
    }
    public Mono<Usuario> registrarUsuarioTecnico(Map<String, Object> body) {
        String nombre = body.get("nombre").toString();
        String apellido = body.get("apellido").toString();
        String email = body.get("email").toString();
        String telefono = body.get("telefono").toString();
        String estado = body.get("estado").toString();
        
        Tecnico nuevo = new Tecnico(null, nombre, apellido, email, telefono, estado);
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(nuevo);
    
        return usuarioRepository.save(usuarioEntity)
                .map(UsuarioEntity::toDomainModel);
    }
    
    public Mono<Usuario> LoginEmail(Map<String, Object> body) {
        String email = body.get("email").toString();
        
        return usuarioRepository.findByEmail(email)
                .flatMap(usuarioEntity -> Mono.just(usuarioEntity.toDomainModel()))
                .switchIfEmpty(Mono.empty());
    }
    
}
