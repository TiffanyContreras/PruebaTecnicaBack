package com.tiffany.pruebatecnica.service;


import com.tiffany.pruebatecnica.modelo.Cliente;
import com.tiffany.pruebatecnica.modelo.Role;
import com.tiffany.pruebatecnica.modelo.Usuario;
import com.tiffany.pruebatecnica.modelo.UsuarioRol;
import com.tiffany.pruebatecnica.repository.RoleRepository;
import com.tiffany.pruebatecnica.repository.RoleUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;

@Slf4j
@Service
public class RoleUserSrv {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleUserRepository roleUserRepository;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void guardarRolCliente(Usuario usuario) {
        log.info("Guardando relacion del usuario con el rol");

        Role rolUser = this.roleRepository.findByNombreRol("USER");
        if (rolUser == null) {

            throw new RestClientException("no es posible asignar el rol al usuario");

        }
        this.roleUserRepository.save(new UsuarioRol(usuario, rolUser));

    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void guardarRolAdmin(Usuario usuario) {
        log.info("Guardando relacion del usuario con el rol");

        Role rolUser = this.roleRepository.findByNombreRol("ADMIN");
        if (rolUser == null) {

            throw new RestClientException("no es posible asignar el rol al usuario");

        }

        this.roleUserRepository.save(new UsuarioRol(usuario, rolUser));

    }

}
