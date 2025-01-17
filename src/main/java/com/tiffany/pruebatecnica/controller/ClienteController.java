package com.tiffany.pruebatecnica.controller;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import com.tiffany.pruebatecnica.dto.InformacionClienteProjection;
import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.service.ClienteSrv;
import com.tiffany.pruebatecnica.service.EmpleadoSrv;
import com.tiffany.pruebatecnica.service.UserClienteSrv;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("clientes/v1/")
public class ClienteController {
    @Autowired
    UserClienteSrv userClienteSrv;
    @Autowired
    ClienteSrv clienteSrv;

    @PostMapping(value = "crear")
    @Operation(summary = "crea usuario tipo cliente", description = "crea el usuario del cliente")
    public ResponseEntity<String> crearCliente(@RequestBody @Valid ClienteDto cliente) {
        try {
            userClienteSrv.GuardarCliente(cliente);
            return ResponseEntity.ok("Cliente creado correctamente");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }


    }

    @GetMapping(value = "lista")
    @Operation(summary = "lista informacion del cliente", description = "obtiene informacion de contacto del cliente")
    public List<InformacionClienteProjection> listarClientes() {
        return clienteSrv.listarClientes();

    }

    @PutMapping(value = "actualizar/{id}")
    @Operation(summary = "Actualiza los datos del cliente", description = "Actualiza los datos existentes del cliente")
    public ResponseEntity<String> actualizarCliente(@RequestBody @Valid ClienteDto cliente, @PathVariable Integer id) {
        try {
            clienteSrv.ActualizarCliente(cliente, id);
            return ResponseEntity.ok("Cliente actualizado correctamente");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @DeleteMapping(value = "elimina/{id}")
    @Operation(summary = "Elimina un dato", description = "Elimina un dato registrado")
    public ResponseEntity<String> eliminarCliente(@PathVariable @Valid @NotNull(message = "El id del cliente es requerido") Integer id) {
        try {
            clienteSrv.eliminarCliente(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

}