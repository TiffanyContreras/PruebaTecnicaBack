package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {

    @NotEmpty(message = "Ingrese un usuario válido")
    private String usuario;
    @NotEmpty(message = "Ingrese una clave valida")
    private String contrasena;
}
