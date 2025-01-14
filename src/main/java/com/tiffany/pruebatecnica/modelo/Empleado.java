package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "empleados", schema = "app_prestamo")
public class Empleado {
    @Id
    @Column(name = "id_empleado", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_empleado", nullable = false)
    private com.tiffany.pruebatecnica.modelo.Usuario usuarios;

    @Nationalized
    @Column(name = "nombre_empleado", nullable = false, length = 100)
    private String nombreEmpleado;

    @Nationalized
    @Column(name = "apellido_empleado", nullable = false, length = 100)
    private String apellidoEmpleado;

}