package com.tiffany.pruebatecnica.controller;


import com.tiffany.pruebatecnica.dto.CataloHijoProjection;
import com.tiffany.pruebatecnica.service.CatalogoSrv;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("catalogo/v1/")
public class CatalogoController {

    @Autowired
    CatalogoSrv catalogoSrv;

    @GetMapping("hijo/by/padre/{idPadre}")
    @Operation(summary = "Obtiene el listado de catalogos hijos")
    public List<CataloHijoProjection> obtenerCatalogosHijos(@PathVariable Integer idPadre) {
        try {

            return this.catalogoSrv.obtenerCatalogoHijoByPadre(idPadre);
        } catch (Exception e) {
            log.error("Ocurrio un error al obtener los catalogos para el id indicado", e);
            return new ArrayList<CataloHijoProjection>();
        }


    }

}
