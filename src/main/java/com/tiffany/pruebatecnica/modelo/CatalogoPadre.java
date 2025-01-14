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
@Table(name = "catalogo_padre", schema = "app_prestamo")
public class CatalogoPadre {
    @Id
    @Column(name = "id_padre", nullable = false)
    private Integer id;

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