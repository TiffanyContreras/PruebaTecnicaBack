package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "catalogo_hijo", schema = "app_prestamo")
public class CatalogoHijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hijo", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_padre", nullable = false)
    private com.tiffany.pruebatecnica.modelo.CatalogoPadre idPadre;

    @Nationalized
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Nationalized
    @Column(name = "descripcion", length = 500)
    private String descripcion;

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