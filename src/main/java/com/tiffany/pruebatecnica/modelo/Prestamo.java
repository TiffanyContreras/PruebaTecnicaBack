package com.tiffany.pruebatecnica.modelo;

import com.tiffany.pruebatecnica.dto.PrestamoDto;
import com.tiffany.pruebatecnica.util.Constantes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor

@Table(name = "prestamos", schema = "app_prestamo")
public class Prestamo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modifica")
    private LocalDate fechaModifica;


    @Column(name = "usuario_aprueba")
    private Integer  usuarioAprueba;

    public Prestamo(PrestamoDto prestamoDto, Cliente cliente) {
        this.cliente = cliente;
        this.montoSolicitado = prestamoDto.getMontoSolicitado();
        this.plazo = prestamoDto.getPlazoSolicitado();
        this.estado= Constantes.EN_PROCESO;
        this.fechaCreacion = LocalDate.now();


    }
}