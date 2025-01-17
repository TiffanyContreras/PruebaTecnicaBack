package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.UsuarioRol;
import com.tiffany.pruebatecnica.modelo.UsuarioRolId;
import org.springframework.data.repository.CrudRepository;

public interface RoleUserRepository extends CrudRepository<UsuarioRol, UsuarioRolId> {




}
