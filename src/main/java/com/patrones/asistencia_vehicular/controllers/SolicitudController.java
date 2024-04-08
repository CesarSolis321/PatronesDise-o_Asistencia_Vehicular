package com.patrones.asistencia_vehicular.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.asistencia_vehicular.models.solicitud.Solicitud;
import com.patrones.asistencia_vehicular.services.SolicitudService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-solicitud")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    
    @PostMapping("/crear")
    public Mono<Solicitud> crearSolicitud (@RequestBody Map<String,Object> body){
        System.out.println("recibio peticion crear solicitud");
        return solicitudService.crearSolicitud(body);
    }

    @GetMapping
    public Flux<Solicitud> mostrarTodasLasSolicitudes(){
        return solicitudService.mostrarTodasLasSolicitudes();
    }
}
