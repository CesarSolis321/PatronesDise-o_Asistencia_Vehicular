package com.patrones.asistencia_vehicular.models.solicitud;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patrones.asistencia_vehicular.utils.IObservable;
import com.patrones.asistencia_vehicular.utils.IObservador;

public class Solicitud implements IObservable {
    private Long id;

    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
    private String ubicacion;
    private String fecha;
    private String modeloCarro;
    private String descripcion;

    @JsonIgnore
    private List<IObservador> observadores;

    public Solicitud(Long id, String nombreCliente, String apellidoCliente, String telefono, String ubicacion,
            String fecha, String modeloCarro, String descripcion) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.modeloCarro = modeloCarro;
        this.descripcion = descripcion;

        this.observadores = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Solicitud [id=" + id + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente
                + ", telefono=" + telefono + ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", modeloCarro="
                + modeloCarro + ", descripcion=" + descripcion + "]";
    }

    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void quitarObservador(IObservador observador) {
        observadores.remove(observador);
    }

    public void notificar(String cambiosRealizados){
        for (IObservador observador : observadores) {
            observador.notificarSolicitudCreada(cambiosRealizados, this );
        }
    }
}
