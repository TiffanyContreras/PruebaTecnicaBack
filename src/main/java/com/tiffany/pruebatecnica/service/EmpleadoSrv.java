package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.modelo.Empleado;
import com.tiffany.pruebatecnica.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service

public class EmpleadoSrv {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public void save(EmpleadoDto empleadoDto, int idUsuario) {
        verificaNombreEmpleado(empleadoDto.getNombre());
       verificaApellidoEmpleado(empleadoDto.getApellido());

        Empleado empleado = new Empleado(idUsuario, empleadoDto);
        empleadoRepository.save(empleado);

    }

    public void verificaNombreEmpleado(String nombreEmpleado) {
        if (empleadoRepository.existsByNombreEmpleado(nombreEmpleado)) {
            throw new RuntimeException("El nombre del empleado ya existe");
        }


    }

    public void verificaApellidoEmpleado(String apellidoEmpleado) {
        if (empleadoRepository.existsByApellidoEmpleado(apellidoEmpleado)) {
            throw new RuntimeException("El apellido del empleado ya existe");
        }


    }

}

