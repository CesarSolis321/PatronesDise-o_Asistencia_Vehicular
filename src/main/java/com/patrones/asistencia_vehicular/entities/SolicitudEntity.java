package com.patrones.asistencia_vehicular.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.patrones.asistencia_vehicular.models.solicitud.Solicitud;

import reactor.core.publisher.Mono;

@Table("solicitud")
public class SolicitudEntity {
    @Id
    private Long id;

    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
    private String ubicacion;
    private String fecha;
    private String modeloCarro;
    private String descripcion;



    public SolicitudEntity(Long id, String nombreCliente, String apellidoCliente, String telefono, String ubicacion,
            String fecha, String modeloCarro, String descripcion) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.modeloCarro = modeloCarro;
        this.descripcion = descripcion;
    }

    public static SolicitudEntity fromDomainModel( Solicitud solicitud ) {
        return new SolicitudEntity( solicitud.getId(), solicitud.getNombreCliente(), solicitud.getApellidoCliente(), solicitud.getTelefono(), solicitud.getUbicacion(), solicitud.getFecha(), solicitud.getModeloCarro(), solicitud.getDescripcion());
    }

    public Solicitud toDomainModel()  {

        return new Solicitud(id, nombreCliente, apellidoCliente, telefono, ubicacion, fecha, modeloCarro, descripcion);
    }

    public Mono<Solicitud> toDomainModelMono()  {

        return Mono.just(new Solicitud(id, nombreCliente, apellidoCliente, telefono, ubicacion, fecha, modeloCarro, descripcion));
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
        return "SolicitudEntity [id=" + id + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente
                + ", telefono=" + telefono + ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", modeloCarro="
                + modeloCarro + ", descripcion=" + descripcion + "]";
    }

}
