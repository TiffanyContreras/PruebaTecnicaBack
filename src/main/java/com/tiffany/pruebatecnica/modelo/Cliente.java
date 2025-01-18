package com.tiffany.pruebatecnica.modelo;

import ch.qos.logback.core.net.server.Client;
import com.tiffany.pruebatecnica.dto.ClienteDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "clientes", schema = "app_prestamo")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cliente", nullable = false)
    private Integer id;


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
    private Date fechaNacimiento;

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

    public Cliente(Integer id, ClienteDto clienteDto) {
        this.id = id;
        this.numeroIdentificacion = clienteDto.getNumeroIdentificacion();
        this.nombreCliente = clienteDto.getNombreCliente();
        this.apellidoCliente = clienteDto.getApellidoCliente();
        this.fechaNacimiento = clienteDto.getFechaNacimiento();
        this.numeroTelefono = clienteDto.getNumeroTelefono();
        this.departamento = 1;
        this.municipio = 1;
        this.direccionCliente = clienteDto.getDireccionCliente();
        this.correoElectronico = clienteDto.getCorreoElectronico();


    }
}