package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.PrestamosAprobadosProjection;
import com.tiffany.pruebatecnica.service.PrestamoAprobadoSrv;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.DescriptorKey;
import java.util.List;

@RestController
@RequestMapping("aprobado/v1/")
public class PrestamosAprobadosController {
    @Autowired
    PrestamoAprobadoSrv prestamoAprobadoSrv;
    @GetMapping (value="obtener")
    @Operation(summary = "informacion prestamos aprobados", description = "muestra la informacion relevante de los pagos")
    public List<PrestamosAprobadosProjection> obtenerPrestamosAprobados(){
        try{

            return prestamoAprobadoSrv.obtenerPrestamoAprobados();

        }catch(Exception e) {

            throw new RuntimeException("Error al obtener los prestamos aprobados");
        }

    }
}
