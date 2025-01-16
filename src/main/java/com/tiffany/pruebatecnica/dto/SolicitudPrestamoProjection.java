package com.tiffany.pruebatecnica.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SolicitudPrestamoProjection {

    Integer getPlazo();
    BigDecimal getMontoSolicitado();
    LocalDate getFechaCreacion();
    String getEstado();
    Integer getClienteId();
    String getInformacionCliente();
    Integer getNumeroTelefono();



}


