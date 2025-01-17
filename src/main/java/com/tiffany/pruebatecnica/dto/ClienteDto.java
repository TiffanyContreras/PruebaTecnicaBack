package com.tiffany.pruebatecnica.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;


@Data
@NoArgsConstructor
public class ClienteDto extends UsuarioDto {
    @NotEmpty(message = "El documento de identificacion es requerido")
    private String numeroIdentificacion;
    @NotEmpty(message = "El nombre es requerido")
    private String nombreCliente;
    @NotEmpty(message = "El apellido es requerido")
    private String apellidoCliente;
    @NotNull(message = "La fecha de nacimiento es requerida")
    private Date fechaNacimiento;
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "El correo ingresado no es valido")
    @NotEmpty(message = "El correo no puede ser nulo o vacio")
    private String correoElectronico;
    @Min(value = 8, message = "El telefono no puede ser menor de 8 digitos")
    @Max(value = 8, message = "El telefono no pude ser mayor a 8 digitos")
    private String numeroTelefono;
    private Integer departamento;
    private Integer municipio;
    @Max(value = 500, message = "La direccion no puede ser mayor a 500 caracteres")
    private String direccionCliente;

    public ClienteDto(String username, String password, String numeroIdentificacion, String nombreCliente, String apellidoCliente, Date fechaNacimiento, String correoElectronico, Integer departamento, String numeroTelefono, Integer municipio, String direccionCliente) {
        super(username, password);
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.departamento = departamento;
        this.numeroTelefono = numeroTelefono;
        this.municipio = municipio;
        this.direccionCliente = direccionCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto that = (ClienteDto) o;
        return Objects.equals(numeroIdentificacion, that.numeroIdentificacion) && Objects.equals(nombreCliente, that.nombreCliente) && Objects.equals(apellidoCliente, that.apellidoCliente) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(correoElectronico, that.correoElectronico) && Objects.equals(numeroTelefono, that.numeroTelefono) && Objects.equals(departamento, that.departamento) && Objects.equals(municipio, that.municipio) && Objects.equals(direccionCliente, that.direccionCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroIdentificacion, nombreCliente, apellidoCliente, fechaNacimiento, correoElectronico, numeroTelefono, departamento, municipio, direccionCliente);
    }


}
