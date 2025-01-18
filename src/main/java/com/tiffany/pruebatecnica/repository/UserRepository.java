package com.tiffany.pruebatecnica.repository;

import com.tiffany.pruebatecnica.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository  extends JpaRepository<Usuario, Integer> {
    public boolean existsByUsernameUsuario(String username);
  Optional<Usuario> findByUsernameUsuario(String username);

  @Query(value = "select r.nombre_rol   from app_prestamo.usuarios u   \n" +
          "join app_prestamo.usuario_rol ur on ur.id_usuario =u.id_usuario \n" +
          "join app_prestamo.roles r on r.id_rol =ur.id_rol \n" +
          "where u.username_usuario =:name",nativeQuery = true)
  List<String> obtenerRolesByUserName(@Param("name") String userName);
}
