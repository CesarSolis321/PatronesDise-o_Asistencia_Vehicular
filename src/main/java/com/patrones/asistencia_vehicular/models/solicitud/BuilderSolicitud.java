package com.patrones.asistencia_vehicular.models.solicitud;

public class BuilderSolicitud implements IBuilderSolicitud{
    private String nombreCliente;
    private String apellidoCliente;
    private String telefono;
    private String ubicacion;
    private String fecha;
    private String modeloCarro;
    private String descripcion;
    public BuilderSolicitud(String nombreCliente, String apellidoCliente, String telefono, String ubicacion) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }
    
    @Override
    public String toString() {
        return "BuilderSolicitud [nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente
                + ", telefono=" + telefono + ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", modeloCarro="
                + modeloCarro + ", descripcion=" + descripcion + "]";
    }

    @Override
    public IBuilderSolicitud withFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    @Override
    public IBuilderSolicitud withModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
        return this;
    }

    @Override
    public IBuilderSolicitud withDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Solicitud build(){
        //Solicitud solicitud = new Solicitud();
        Solicitud solicitud = new Solicitud(null, nombreCliente, apellidoCliente, telefono, ubicacion, fecha, modeloCarro, descripcion);
        /*
        solicitud.setNombreCliente(nombreCliente);
        solicitud.setApellidoCliente(apellidoCliente);
        solicitud.setTelefono(telefono);
        solicitud.setUbicacion(ubicacion);
        solicitud.setFecha(fecha);
        solicitud.setModeloCarro(modeloCarro);
        solicitud.setDescripcion(descripcion);
        */
        return solicitud;
    }
    
    
}
