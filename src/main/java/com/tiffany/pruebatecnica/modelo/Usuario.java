package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "usuarios", schema = "app_prestamo")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "username_usuario", nullable = false, length = 25)
    private String usernameUsuario;

    @Nationalized
    @Column(name = "password_usuario", nullable = false, length = 3000)
    private String passwordUsuario;

    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Instant fechaModificacion;

    @Nationalized
    @Column(name = "usuario_agrega", nullable = false, length = 25)
    private String usuarioAgrega;

    @Nationalized
    @Column(name = "usuario_modifica", length = 25)
    private String usuarioModifica;

}