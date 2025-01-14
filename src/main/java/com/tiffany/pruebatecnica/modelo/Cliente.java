package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "clientes", schema = "app_prestamo")
public class Cliente {
    @Id
    @Column(name = "id_cliente", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_cliente", nullable = false)
    private com.tiffany.pruebatecnica.modelo.Usuario usuarios;

    @Nationalized
    @Column(name = "numero_identificacion", nullable = false, length = 13)
    private String numeroIdentificacion;

    @Nationalized
    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombreCliente;

    @Nationalized
    @Column(name = "apellido_cliente", nullable = false, length = 100)
    private String apellidoCliente;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Instant fechaNacimiento;

    @Nationalized
    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;

    @Nationalized
    @Column(name = "numero_telefono", nullable = false, length = 50)
    private String numeroTelefono;

    @Column(name = "departamento", nullable = false)
    private Integer departamento;

    @Column(name = "municipio", nullable = false)
    private Integer municipio;

    @Nationalized
    @Column(name = "direccion_cliente", nullable = false, length = 500)
    private String direccionCliente;

}