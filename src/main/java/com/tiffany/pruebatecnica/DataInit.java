package com.tiffany.pruebatecnica;

import com.tiffany.pruebatecnica.modelo.Role;
import com.tiffany.pruebatecnica.modelo.Usuario;
import com.tiffany.pruebatecnica.modelo.UsuarioRol;
import com.tiffany.pruebatecnica.repository.RoleRepository;
import com.tiffany.pruebatecnica.repository.RoleUserRepository;
import com.tiffany.pruebatecnica.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
public class DataInit implements CommandLineRunner {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleUserRepository roleUserRepository;


    @Override
    public void run(String... args) {
        // Roles


        log.info("haciendo algo en consala al inicio");

        Integer idRol1;
        Integer idUsuario1;
        Integer idRol2;
        Integer idUsuario3;

        Usuario usuario = this.userRepository.findByUsernameUsuario("admin").orElseGet(() -> null);
        Role role = this.roleRepository.findByNombreRol("ADMIN");
        Usuario usuarioUser = this.userRepository.findByUsernameUsuario("user").orElseGet(() -> null);
        Role roleUser = this.roleRepository.findByNombreRol("USER");

        if (role == null) {

            Role roleAdmin = new Role("ADMIN");
            role = roleRepository.save(roleAdmin);

            idRol1 = role.getId();
        }


        if (roleUser == null) {

            roleUser = new Role("USER");
            Role rolUserGuardado = roleRepository.save(roleUser);
            idRol2 = rolUserGuardado.getId();
        }


        if (usuario == null) {
            // Usuario Admin
            Usuario admin = new Usuario("admin", passwordEncoder.encode("admin123"));

            usuario = userRepository.save(admin);
            idRol1 = admin.getId();
        }


        if (usuarioUser == null) {
            // Usuario Admin
            Usuario user = new Usuario("user", passwordEncoder.encode("user123"));

            usuarioUser = userRepository.save(user);
            idRol2 = user.getId();

        }

        roleUserRepository.save(new UsuarioRol(usuarioUser, roleUser));
        roleUserRepository.save(new UsuarioRol(usuario, role));

    }
}
