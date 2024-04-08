package com.patrones.asistencia_vehicular.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.patrones.asistencia_vehicular.models.user.Cliente;
import com.patrones.asistencia_vehicular.models.user.Tecnico;
import com.patrones.asistencia_vehicular.models.user.Usuario;

@Table("usuario")
public class UsuarioEntity {
    @Id
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    private String tipoUsuario;

    private String estado;

    public UsuarioEntity(Long id, String nombre, String apellido, String email, String telefono, String tipoUsuario,
            String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }
    public static UsuarioEntity fromDomainModel(Cliente nuevo) {
        return new UsuarioEntity(nuevo.getId(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getTelefono(), "cliente", null);
    }
    public static UsuarioEntity fromDomainModel(Tecnico nuevo) {
        return new UsuarioEntity(nuevo.getId(), nuevo.getNombre(), nuevo.getApellido(), nuevo.getEmail(), nuevo.getTelefono(), "tecnico", nuevo.getEstado());
    }
    public Usuario toDomainModel() {
        return tipoUsuario.equals("cliente")?new Cliente(id, nombre, apellido, email, telefono):new Tecnico(id, nombre, apellido, email, telefono, estado);
    }
}
