package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.dto.InformacionClienteProjection;
import com.tiffany.pruebatecnica.dto.PrestamosEnProcesoProjection;
import com.tiffany.pruebatecnica.dto.SolicitudPrestamoProjection;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamoRepository extends CrudRepository<Prestamo, Integer> {
    @Query(value = "SELECT p.plazo, p.monto_solicitado as montoSolicitado, p.fecha_creacion as fechaCreacion, ch.nombre as estado, p.cliente_id as clienteId, \n" +
            "CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) as informacionCliente, c.numero_telefono as numeroTelefono\n" +
            "FROM app_prestamo.prestamos p \n" +
            "LEFT JOIN app_prestamo.catalogo_hijo ch on p.estado = ch.id_hijo \n" +
            "LEFT JOIN app_prestamo.clientes c on p.cliente_id = c.id_cliente \n" +
            "WHERE p.cliente_id = :id", nativeQuery = true)
    public List<SolicitudPrestamoProjection> listaSolicitudPrestamo(@Param("id") Integer id);


    @Query(value = "SELECT p.id as idPrestamo, p.plazo, p.monto_solicitado as montoSolicitado, p.fecha_creacion as fechaCreacion, ch.nombre as estado, p.cliente_id as clienteId, \n" +
            "            CONCAT(c.nombre_cliente, ' ', c.apellido_cliente) as informacionCliente, c.numero_telefono as numeroTelefono\n" +
            "            FROM app_prestamo.prestamos p \n" +
            "            LEFT JOIN app_prestamo.catalogo_hijo ch on p.estado = ch.id_hijo \n" +
            "            LEFT JOIN app_prestamo.clientes c on p.cliente_id = c.id_cliente \n" +
            "            where p.estado =:estado", nativeQuery = true)
    public List<PrestamosEnProcesoProjection> listaSolicitudPrestamosEnProceso(@Param("estado") Integer estado);


    @Modifying
    @Query(value = " DELETE FROM app_prestamo.prestamos\n" +
            "WHERE  cliente_id=:idCliente and estado not in(3)",nativeQuery = true)
    public int eliminarSolicitudPretamoNoAprobadas(@Param("idCliente") Integer idCliente);
}
