package com.tiffany.pruebatecnica.dto;

import lombok.Data;
@Data
public class RechazaPrestamoDto {

        Integer idPrestamo;
        Integer usuarioRechaza;
        String comentario;
}
