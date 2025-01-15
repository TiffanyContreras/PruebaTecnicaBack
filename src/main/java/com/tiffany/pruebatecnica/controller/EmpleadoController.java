package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import com.tiffany.pruebatecnica.service.UserClienteSrv;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @Slf4j
    @RequestMapping("empleados/v1/")
    public class EmpleadoController {
        @Autowired
        UserClienteSrv userClienteSrv;
        @PostMapping(value="crear")
        @Operation(summary = "crea usuario tipo empleado",description = "crea el usuario del empleado")
        public ResponseEntity<String> crearEmpleado(@RequestBody EmpleadoDto empleado) {
            try {
                userClienteSrv.GuardarEmpleado(empleado);
                return ResponseEntity.ok("Usuario empleado creado correctamente");


            } catch(Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

            }


        }


}
