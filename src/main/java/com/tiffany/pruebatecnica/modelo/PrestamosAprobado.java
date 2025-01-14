package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "prestamos_aprobados", schema = "app_prestamo")
public class PrestamosAprobado {
    @Id
    @Column(name = "id_prestamo_aprobado", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Prestamo idPrestamo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "monto_aprobado", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoAprobado;

    @Column(name = "plazo", nullable = false)
    private Integer plazo;

    @Column(name = "fecha_inicio", nullable = false)
    private Instant fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Instant fechaFin;

    @Column(name = "saldo_pendiente", nullable = false, precision = 18, scale = 2)
    private BigDecimal saldoPendiente;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fecha_creacion", nullable = false)
    private Instant fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Instant fechaModificacion;

    @Nationalized
    @Column(name = "usuario_modifica", length = 25)
    private String usuarioModifica;

}