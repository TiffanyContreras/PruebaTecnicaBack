package com.tiffany.pruebatecnica.controller;


import com.tiffany.pruebatecnica.config.JwtProvider;
import com.tiffany.pruebatecnica.dto.LoginDto;
import com.tiffany.pruebatecnica.service.RoleUserSrv;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/auth/")
public class LoginController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    RoleUserSrv roleUserSrv;

    @PostMapping("login")
    @Operation(summary = "Incicio de sesion", description = "Permite el inicio de sesion a los usuarios dentro de la aplicacion")
    public String login(@RequestBody @Valid LoginDto loginDto) {
        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsuario(), loginDto.getContrasena()));


            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<String> roles = this.roleUserSrv.obtenerNombreRoles(userDetails.getUsername());
            log.info("detalle de roles " + roles);
            return jwtProvider.generateToken(userDetails.getUsername(), roles.stream().map(s -> "ROLE_" + s).collect(Collectors.joining(",")));
        } catch (Exception e) {
            log.error("error al iniciar sesion", e);
            throw new RuntimeException("No es Posible Iniciar sesion");
        }


    }


}
