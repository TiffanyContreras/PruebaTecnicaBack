package com.tiffany.pruebatecnica.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PagoDto {
    private int idPrestamo;
    private BigDecimal abonoPrestamo;
    private String usuarioModifica;


}
