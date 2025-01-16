package com.tiffany.pruebatecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDto {
    private int idCliente;
    private BigDecimal montoSolicitado;
    private int plazoSolicitado;
}
