package com.tiffany.pruebatecnica.modelo;

import com.tiffany.pruebatecnica.dto.PagoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pago", schema = "app_prestamo")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private com.tiffany.pruebatecnica.modelo.Prestamo idPrestamo;

    @Column(name = "abono_pago", nullable = false, precision = 18, scale = 2)
    private BigDecimal abonoPago;

    @Column(name = "fecha_pago")
    private Instant fechaPago;

    public Pago(PagoDto pagoDto, Prestamo prestamo) {
        this.abonoPago=pagoDto.getAbonoPrestamo();
        this.fechaPago= Instant.now();
        this.idPrestamo=prestamo;

    }

    public Pago() {

    }
}