package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.AprobarPrestamoDto;
import com.tiffany.pruebatecnica.dto.PrestamoDto;
import com.tiffany.pruebatecnica.dto.RechazaPrestamoDto;
import com.tiffany.pruebatecnica.dto.SolicitudPrestamoProjection;
import com.tiffany.pruebatecnica.modelo.Prestamo;
import com.tiffany.pruebatecnica.service.PrestamoSrv;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("prestamo/v1/")
public class PrestamoController {
    @Autowired
    PrestamoSrv prestamoSrv;

    @PostMapping(value = "generar")
    @Operation(summary = "genera un prestamo", description = "genera un prestamo en el banco")
    public Integer generarPrestamo(@RequestBody PrestamoDto prestamo) {
        try {

            return prestamoSrv.crearPrestamoSrv(prestamo);


        } catch (Exception e) {
            log.error("Error al crear prestamo", e);
            throw new RuntimeException("Error al crear el prestamo");

        }
    }

    @GetMapping(value = "prestamo/{id}")
    @Operation(summary = "obtiene solicitud prestamo", description = "obtiene todas las solicitudes de prestamo por medio de su id cliente")
    public List<SolicitudPrestamoProjection> obtieneSolicitudPrestamo(@PathVariable Integer id) {
        try {

            return prestamoSrv.ListaPrestamo(id);


        } catch (Exception e) {
            log.error("Error al obtener lista de prestamos", e);
            throw new RuntimeException("Error al obtener lista prestamo");

        }


    }

    @PostMapping(value = "aprobar")
    @Operation(summary = "aprueba el prestamo", description = "aprueba prestamo solicitado")
    public ResponseEntity<String> apruebaPrestamo(@RequestBody AprobarPrestamoDto aprobarPrestamo) {

        try {
            prestamoSrv.aprobarPrestamo(aprobarPrestamo);
            return ResponseEntity.ok("Se ha aprobado el prestamo con exito");


        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @PostMapping(value = "rechaza")
    @Operation(summary = "rechaza el prestamo", description = "rechaza prestamo solicitado")
    public ResponseEntity<String> rechazaPrestamo(@RequestBody RechazaPrestamoDto rechazaPrestamo) {

        try {
            prestamoSrv.rechazarPrestamo(rechazaPrestamo);
            return ResponseEntity.ok("Se ha rechazado el prestamo con exito");


        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }


}


