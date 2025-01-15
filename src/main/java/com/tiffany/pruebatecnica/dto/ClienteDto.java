package com.tiffany.pruebatecnica.dto;

import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;


@Data
@NoArgsConstructor
public class ClienteDto extends UsuarioDto {
    private String numeroIdentificacion;
    private String nombreCliente;
    private String apellidoCliente;
    private Date fechaNacimiento;
    private String correoElectronico;
    private String numeroTelefono;
    private Integer departamento;
    private Integer municipio;
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
