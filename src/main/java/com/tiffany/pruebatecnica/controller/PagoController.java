package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.PagoDto;
import com.tiffany.pruebatecnica.service.PagoSRV;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pago/v1/")
public class PagoController {
    @Autowired
    PagoSRV pagoSRV;
    @PostMapping (value="pagar")
    @Operation(summary = "realiza pago")
    public ResponseEntity<String> pagarPrestamo(@RequestBody PagoDto pago) {
        try {
            pagoSRV.pagar(pago);
            return ResponseEntity.ok("Pago realizado correctamente");


        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }


    }

}
