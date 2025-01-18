package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.dto.InformacionClienteProjection;
import com.tiffany.pruebatecnica.modelo.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    public boolean existsByNumeroIdentificacion(String numeroIdentificacion);

    public boolean existsByCorreoElectronico(String correoElectronico);

    @Query(value = "SELECT c.fecha_nacimiento as fechaNacimiento, c.id_cliente as idCliente, c.numero_telefono as numeroTelefono, c.correo_electronico as correoElectronico, c.direccion_cliente as direccionCliente, \n" +
            "c.numero_identificacion as numeroIdentificacion,\n" +
            "CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) as informacion_cliente ,c.nombre_cliente as nombre, c.apellido_cliente as apellido " +
            "FROM app_prestamo.clientes c ", nativeQuery = true)
    public List <InformacionClienteProjection> listaClienteRegistrado ();





}

