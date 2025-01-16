package com.tiffany.pruebatecnica.modelo;

import com.tiffany.pruebatecnica.util.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "prestamos_aprobados", schema = "app_prestamo")
public class PrestamosAprobado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo_aprobado", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Prestamo idPrestamo;


    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Column(name = "monto_aprobado", nullable = false, precision = 18, scale = 2)
    private BigDecimal montoAprobado;

    @Column(name = "plazo", nullable = false)
    private Integer plazo;

    @Column(name = "fecha_inicio", nullable = false)
    private Instant fechaInicio;

    @Column(name = "fecha_fin", nullable = true)
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

    public PrestamosAprobado(Prestamo prestamo) {
        this.idPrestamo = prestamo;
        this.idCliente = prestamo.getCliente().getId();
        this.montoAprobado = prestamo.getMontoSolicitado();
        this.plazo = prestamo.getPlazo();
        this.fechaInicio = Instant.now();
        this.estado = Constantes.APROBADO;
        this.fechaCreacion = Instant.now();
        this.saldoPendiente = prestamo.getMontoSolicitado();
    }
}