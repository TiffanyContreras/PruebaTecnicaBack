package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.modelo.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

        public boolean existsByNombreEmpleado(String nombreEmpleado);
        public boolean existsByApellidoEmpleado(String apellidoEmpleado);

    }

