package com.tiffany.pruebatecnica.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "prestamos", schema = "app_prestamo")
public class Prestamo {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "monto_solicitado", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoSolicitado;

    @Column(name = "plazo", nullable = false)
    private Integer plazo;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Nationalized
    @Column(name = "detalle_aprobacion", length = 500)
    private String detalleAprobacion;

    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    @Column(name = "fecha_modifica")
    private Instant fechaModifica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_aprueba")
    private com.tiffany.pruebatecnica.modelo.Usuario usuarioAprueba;

}