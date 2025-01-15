package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<Usuario, Integer> {
    public boolean existsByUsernameUsuario(String username);

}
