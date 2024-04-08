package com.patrones.asistencia_vehicular.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.asistencia_vehicular.models.solicitud_usuario.SolicitudUsuario;
import com.patrones.asistencia_vehicular.services.AdminService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/asignar")
    public Mono<SolicitudUsuario> AsignarSolicitudTecnica (@RequestBody Map<String,Object> body){
        return adminService.AsignarSolicitudTecnica(body);
    }


    @PostMapping("/cotizar")
    public Mono<SolicitudUsuario> cotizarServicios(@RequestBody Map<String,String> body){
        return adminService.cotizarServicios(body);
    }
    @PostMapping("/diagnostico")
    public Mono<SolicitudUsuario> diagnosticoServicios(@RequestBody Map<String,String> body){
        return adminService.diagnosticoServicios(body);
    }
    @PostMapping("/pagar")
    public Mono<SolicitudUsuario> realizarPago(@RequestBody Map<String,Object> body){
        return adminService.realizarPago(body);
    }
    
}
