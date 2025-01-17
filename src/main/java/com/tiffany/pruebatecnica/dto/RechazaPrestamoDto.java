package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RechazaPrestamoDto {

    @NotNull(message = "El id del prestamo es requerido")
    Integer idPrestamo;
    @NotNull(message = "El id del usuario que realiza la operacion es requerido")
    Integer usuarioRechaza;

    String comentario;
}
