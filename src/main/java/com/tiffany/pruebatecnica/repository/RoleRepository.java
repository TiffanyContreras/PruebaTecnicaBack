package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByNombreRol(String nombre);


}
