package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.*;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.service.PrestamoSrv;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("prestamo/v1/")
public class PrestamoController {
    @Autowired
    PrestamoSrv prestamoSrv;

    @PostMapping(value = "generar")
    @Operation(summary = "genera un prestamo", description = "genera un prestamo en el banco")
    public Integer generarPrestamo(@RequestBody @Valid PrestamoDto prestamo) {
        try {

            return prestamoSrv.crearPrestamoSrv(prestamo);


        } catch (Exception e) {
            log.error("Error al crear prestamo", e);
            throw new RuntimeException("Error al crear el prestamo");

        }
    }

    @GetMapping(value = "prestamo/{id}")
    @Operation(summary = "obtiene solicitud prestamo", description = "obtiene todas las solicitudes de prestamo por medio de su id cliente")
    public List<SolicitudPrestamoProjection> obtieneSolicitudPrestamo(@PathVariable @Valid @NotNull(message = "El id del cliente es requerido") Integer id) {
        try {

            return prestamoSrv.ListaPrestamo(id);


        } catch (Exception e) {
            log.error("Error al obtener lista de prestamos", e);
            throw new RuntimeException("Error al obtener lista prestamo");

        }


    }

    @PostMapping(value = "aprobar")
    @Operation(summary = "aprueba el prestamo", description = "aprueba prestamo solicitado")
    public ResponseEntity<String> apruebaPrestamo(@RequestBody @Valid AprobarPrestamoDto aprobarPrestamo) {

        try {
            prestamoSrv.aprobarPrestamo(aprobarPrestamo);
            return ResponseEntity.ok("Se ha aprobado el prestamo con exito");


        } catch (Exception e) {
            log.error("Error al aprobar prestamo", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @PostMapping(value = "rechaza")
    @Operation(summary = "rechaza el prestamo", description = "rechaza prestamo solicitado")
    public ResponseEntity<String> rechazaPrestamo(@RequestBody @Valid RechazaPrestamoDto rechazaPrestamo) {

        try {
            prestamoSrv.rechazarPrestamo(rechazaPrestamo);
            return ResponseEntity.ok("Se ha rechazado el prestamo con exito");


        } catch (Exception e) {
            log.error("Ocurrio un error al rechazar el prestamo", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @GetMapping(value = "lista/en-proceso")
    @Operation(summary = "Obtiene los prestamos con estado en proceso")
    public List<PrestamosEnProcesoProjection> listaPrestamoEnProceso() {

        try {
            return this.prestamoSrv.obtenerPrestamosParaAprobacionRechazo();
        } catch (Exception e) {
            log.error("Ocurrio un error al obtener la solicitud de prestamos ", e);
            throw new RestClientException("No fue posible obtener las solicitudes de prestamos");
        }
    }

}


