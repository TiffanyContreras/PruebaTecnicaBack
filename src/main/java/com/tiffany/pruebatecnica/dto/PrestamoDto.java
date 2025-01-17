package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDto {
    @NotNull(message = "El id del cliente es requerido")
    private int idCliente;
    @NotNull(message = "El monto solocitado  es requerido")
    private BigDecimal montoSolicitado;
    @NotNull(message = "EL plazo es requerido")
    private int plazoSolicitado;
}
