package com.tiffany.pruebatecnica.dto;

import java.math.BigDecimal;

public interface PrestamosAprobadosProjection {
    Integer getIdCliente();
    Integer getIdPrestamo();
    Integer getNumeroTelefono();
    String getNombreCliente();
    BigDecimal getMontoAprobado();
    BigDecimal getSaldoPendiente();
    Integer getCantidadPagos();
    


}
