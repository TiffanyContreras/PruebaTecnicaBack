package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmpleadoDto extends UsuarioDto {
    @NotEmpty(message = "El Nombre es requerido")
    private String nombre;
    @NotEmpty(message = "El Apellido es requerido")
    private String apellido;

    public EmpleadoDto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public EmpleadoDto(String username, String password, String nombre, String apellido) {
        super(username, password);
        this.nombre = nombre;
        this.apellido = apellido;
    }
}

