package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;
import org.hibernate.proxy.HibernateProxy;

import java.time.Instant;
import java.util.Objects;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        CatalogoPadre that = (CatalogoPadre) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}