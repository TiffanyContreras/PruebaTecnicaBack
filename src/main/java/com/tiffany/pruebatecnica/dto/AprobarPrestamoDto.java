package com.tiffany.pruebatecnica.dto;

import lombok.Data;

@Data
public class AprobarPrestamoDto {
    Integer idPrestamo;
    Integer usuarioAprueba;
    String comentario;


}
