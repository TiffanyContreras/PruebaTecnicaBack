package com.tiffany.pruebatecnica.repository;


import com.tiffany.pruebatecnica.dto.PrestamosAprobadosProjection;
import com.tiffany.pruebatecnica.dto.SolicitudPrestamoProjection;
import com.tiffany.pruebatecnica.modelo.PrestamosAprobado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamoAprobadoRepository extends CrudRepository<PrestamosAprobado, Integer> {
    @Query(value = "SELECT pa.id_cliente as idCliente,pa.id_prestamo as idPrestamo, c.numero_telefono  as numeroTelefono, c.nombre_cliente  as \n" +
            "nombreCliente, pa.monto_aprobado as montoAprobado, pa.saldo_pendiente , COUNT(p.id_prestamo)as cantidadPagos\n" +
            "FROM app_prestamo.prestamos_aprobados pa \n" +
            "left join app_prestamo.pago p on p.id_prestamo = pa.id_prestamo \n" +
            "left join app_prestamo.clientes c on c.id_cliente = pa.id_cliente \n" +
            "group by pa.id_cliente , pa.id_prestamo , c.numero_telefono , c.nombre_cliente, pa.monto_aprobado , pa.saldo_pendiente ", nativeQuery = true)
    public List<PrestamosAprobadosProjection> listaPrestamoAprobados ();



}
