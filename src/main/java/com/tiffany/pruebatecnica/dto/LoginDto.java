package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {

    @NotEmpty
    private String usuario;
    @NotEmpty
    private String contrasena;
}
