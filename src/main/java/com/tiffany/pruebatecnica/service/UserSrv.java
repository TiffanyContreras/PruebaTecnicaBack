package com.tiffany.pruebatecnica.service;

import com.tiffany.pruebatecnica.dto.ClienteDto;
import com.tiffany.pruebatecnica.dto.EmpleadoDto;
import com.tiffany.pruebatecnica.dto.UsuarioDto;

import com.tiffany.pruebatecnica.modelo.Usuario;
import com.tiffany.pruebatecnica.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j

public class UserSrv {
    @Autowired UserRepository usuarioRepository;
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int save(ClienteDto userDto) {
        log.info("guardando cliente", userDto);
        verificarNombreDeUsuario(userDto.getUsername());
        Usuario usuario = new Usuario(userDto.getUsername(), userDto.getPassword());
        Usuario usuarioGuardar = usuarioRepository.save(usuario);
        this.usuarioRepository.flush();
        return usuarioGuardar.getId();
    }

    public void verificarNombreDeUsuario(String nombreDeUsuario) {
        if (usuarioRepository.existsByUsernameUsuario(nombreDeUsuario)){
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
}