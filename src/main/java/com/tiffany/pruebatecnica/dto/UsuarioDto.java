package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {
    @NotEmpty(message = "El nombre de usuario es requerido")
    private String username;
    @NotEmpty(message = "Ingrese un clave valida")
    private String password;

    public UsuarioDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
