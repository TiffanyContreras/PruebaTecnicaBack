package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;

import com.tiffany.pruebatecnica.modelo.Role;
import com.tiffany.pruebatecnica.modelo.Usuario;
import com.tiffany.pruebatecnica.repository.RoleRepository;
import com.tiffany.pruebatecnica.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserSrv implements UserDetailsService {


    private final UserRepository usuarioRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserSrv(UserRepository usuarioRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int save(ClienteDto userDto) {
        log.info("guardando cliente", userDto);
        verificarNombreDeUsuario(userDto.getUsername());
        Usuario usuario = new Usuario(userDto.getUsername(), bCryptPasswordEncoder.encode(userDto.getPassword()));

        Usuario usuarioGuardar = usuarioRepository.save(usuario);
        this.usuarioRepository.flush();
        return usuarioGuardar.getId();
    }

    public void verificarNombreDeUsuario(String nombreDeUsuario) {
        if (usuarioRepository.existsByUsernameUsuario(nombreDeUsuario)) {
            throw new RuntimeException("El usuario no existe");
        }


    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int saveUserEmpleado(EmpleadoDto userDto) {
        verificarNombreDeUsuario(userDto.getUsername());
        Usuario usuario = new Usuario(userDto.getUsername(), userDto.getPassword());
        Usuario usuarioGuardar = usuarioRepository.save(usuario);
        this.usuarioRepository.flush();
        return usuarioGuardar.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepository.findByUsernameUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        List<String> roles = usuarioRepository.obtenerRolesByUserName(username);

        var authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUsernameUsuario(),
                user.getPasswordUsuario(),
                authorities);
    }
}