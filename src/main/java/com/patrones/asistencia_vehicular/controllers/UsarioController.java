package com.patrones.asistencia_vehicular.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.asistencia_vehicular.models.user.Usuario;
import com.patrones.asistencia_vehicular.services.UsuarioService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-usuario")
public class UsarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public String conseguirTodosLosUsuarios(){
        System.out.println("Recibio peticion para conseguir todos los usuarios");
        return "todos los usuarios";
    }
    @PostMapping("/registroCliente")
    public Mono<Usuario> registrarUsuarioCliente(@RequestBody Map<String,Object> body){
        return usuarioService.registrarUsuarioCliente(body);
    }
    @PostMapping("/registroTecnico")
    public Mono<Usuario> registrarUsuarioTecnico(@RequestBody Map<String,Object> body){
        return usuarioService.registrarUsuarioTecnico(body);
    }
    @PostMapping("/loginEmail")
    public Mono<Usuario> LoginEmail(@RequestBody Map<String,Object> body){
        return usuarioService.LoginEmail(body);
    }
}
