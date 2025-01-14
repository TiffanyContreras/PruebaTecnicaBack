package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@Table(name = "roles", schema = "app_prestamo")
public class Role {
    @Id
    @Column(name = "id_rol", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombreRol;

}