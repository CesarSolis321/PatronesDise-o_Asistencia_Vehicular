package com.patrones.asistencia_vehicular.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.asistencia_vehicular.entities.SolicitudUsuarioEntity;
import com.patrones.asistencia_vehicular.entities.UsuarioEntity;
import com.patrones.asistencia_vehicular.models.pagos.IStrategyMetodoPago;
import com.patrones.asistencia_vehicular.models.pagos.MetodoCash;
import com.patrones.asistencia_vehicular.models.pagos.MetodoCreditCard;
import com.patrones.asistencia_vehicular.models.pagos.MetodoPaypal;
import com.patrones.asistencia_vehicular.models.servicios.ExpresionServicio;
import com.patrones.asistencia_vehicular.models.servicios.IExpresion;
import com.patrones.asistencia_vehicular.models.servicios.IServicio;
import com.patrones.asistencia_vehicular.models.servicios.InterpreterContexto;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicional;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalAbastecimientoCombustible;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalCambioLlanta;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalLlavesDentroDelAuto;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalRemolque;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalRescate;
import com.patrones.asistencia_vehicular.models.servicios.ServicioAdicionalSotanera;
import com.patrones.asistencia_vehicular.models.servicios.ServicioTecnicoBase;
import com.patrones.asistencia_vehicular.models.solicitud_usuario.SolicitudUsuario;
import com.patrones.asistencia_vehicular.models.user.Cliente;
import com.patrones.asistencia_vehicular.models.user.Usuario;
import com.patrones.asistencia_vehicular.repositories.SolicitudUsuarioRepository;
import com.patrones.asistencia_vehicular.repositories.UsuarioRepository;
import com.patrones.asistencia_vehicular.utils.InterpreterClient;
import com.patrones.asistencia_vehicular.utils.InterpreterEngine;

import reactor.core.publisher.Mono;

@Service
public class AdminService {
    @Autowired
    SolicitudUsuarioRepository solicitudUsuarioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public Mono<SolicitudUsuario> AsignarSolicitudTecnica(Map<String,Object> body) {
        SolicitudUsuario solicitudUsuario = new SolicitudUsuario();
        solicitudUsuario.setIdUsuario(body.get("idUsuario").toString());
        solicitudUsuario.setIdSolicitud(body.get("idSolicitud").toString());

        SolicitudUsuarioEntity solicitudUsuarioEntity = SolicitudUsuarioEntity.fromDomainModel(solicitudUsuario);

        return Mono.just(solicitudUsuarioRepository.save(solicitudUsuarioEntity).doOnSuccess(pl -> {}).block().toDomainModel());
    }

    public void test(String string) {
        System.out.println(string);
    }

    public void testDecorador() {
        IServicio servicioPedido = new ServicioTecnicoBase();

        servicioPedido = new ServicioAdicionalRescate(servicioPedido);
        servicioPedido = new ServicioAdicionalRemolque(servicioPedido);

        System.out.println("costo: " + servicioPedido.generarCodigoServicio());
    }

    public Mono<SolicitudUsuario> cotizarServicios(Map<String, String> body) {
        Long idSolicitudUsuario = Long.parseLong(body.get("idSolicitudUsuario").toString());


        SolicitudUsuario solicitudUsuario = solicitudUsuarioRepository.findById(idSolicitudUsuario).block().toDomainModel();
        String codigo = solicitudUsuario.getCodigoServicio();
 
        InterpreterEngine interpreterEngine = new InterpreterEngine();
        InterpreterClient interpreterClient = new InterpreterClient(interpreterEngine);
        solicitudUsuario.setMonto(interpreterClient.interpret(codigo));
        return Mono.just(solicitudUsuarioRepository.save(SolicitudUsuarioEntity.fromDomainModel(solicitudUsuario)).doOnSuccess(pl -> {}).block().toDomainModel());
        
       
        //return Mono.just(codigo);

    }

    public Mono<SolicitudUsuario> realizarPago(Map<String, Object> body) { 
        List<IStrategyMetodoPago> metodosDePago = new ArrayList<>();
        metodosDePago.add(new MetodoPaypal());
        metodosDePago.add(new MetodoCreditCard());
        metodosDePago.add(new MetodoCash());

        Long idSolicitudUsuario =  Long.parseLong(body.get("idSolicitudUsuario").toString());
        SolicitudUsuarioEntity solicitudUsuarioEntity = solicitudUsuarioRepository.findById(idSolicitudUsuario).block();
        SolicitudUsuario solicitudUsuario = solicitudUsuarioEntity.toDomainModel();

        // Configurar la estrategia de pago según el caso
        int idMetodoPago = Integer.parseInt(body.get("idMetodoPago").toString());

        Cliente cliente  = (Cliente)usuarioRepository.findById(Long.parseLong(solicitudUsuario.getIdUsuario())).block().toDomainModel();

        cliente.setMetodoPago(metodosDePago.get(idMetodoPago));

        if(cliente.realizarPago(solicitudUsuario.getMonto())){
            solicitudUsuario.setMonto(-1);
        }

        return Mono.just(solicitudUsuario);
    }
    
    
    public Mono<SolicitudUsuario> diagnosticoServicios(Map<String, String> body) {
        IServicio servicioPedido = new ServicioTecnicoBase();

        if(body.get("abastecimiento").equals("true")){
            servicioPedido = new ServicioAdicionalAbastecimientoCombustible(servicioPedido);
        }
        if(body.get("cambioLlanta").equals("true")){
            servicioPedido = new ServicioAdicionalCambioLlanta(servicioPedido);
        }
        if(body.get("llaves").equals("true")){
            servicioPedido = new ServicioAdicionalLlavesDentroDelAuto(servicioPedido);
        }
        if(body.get("remolque").equals("true")){
            servicioPedido = new ServicioAdicionalRemolque(servicioPedido);
        }
        if(body.get("rescate").equals("true")){
            servicioPedido = new ServicioAdicionalRescate(servicioPedido);
        }
        if(body.get("sotanera").equals("true")){
            servicioPedido = new ServicioAdicionalSotanera(servicioPedido);
        }

        Long idSolicitudUsuario = Long.parseLong(body.get("idSolicitudUsuario").toString());
        SolicitudUsuario solicitudUsuario = solicitudUsuarioRepository.findById(idSolicitudUsuario).block().toDomainModel();
        solicitudUsuario.setCodigoServicio(servicioPedido.generarCodigoServicio());

        return Mono.just(solicitudUsuarioRepository.save(SolicitudUsuarioEntity.fromDomainModel(solicitudUsuario)).doOnSuccess(pl -> {}).block().toDomainModel() );
    }
    
}

