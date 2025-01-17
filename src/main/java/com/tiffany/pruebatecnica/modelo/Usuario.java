package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "usuarios", schema = "app_prestamo")
public class Usuario {
    @Id
    @Column(name = "id_usuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera un valor, usa misma serie que bd
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


    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UsuarioRol> roles = new HashSet<>();


    public Usuario(String usernameUsuario, String passwordUsuario) {
        this.usernameUsuario = usernameUsuario;
        this.passwordUsuario = passwordUsuario;
        this.fechaCreacion = Instant.now();
        this.usuarioAgrega = "log_app_ms_prestamo";
    }


}