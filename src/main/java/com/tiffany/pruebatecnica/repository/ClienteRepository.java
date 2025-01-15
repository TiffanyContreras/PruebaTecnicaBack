package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    public boolean existsByNumeroIdentificacion(String numeroIdentificacion);
    public boolean existsByCorreoElectronico(String correoElectronico);

}
