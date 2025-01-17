package com.tiffany.pruebatecnica.config;


import com.tiffany.pruebatecnica.service.UserSrv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {


    @Bean
    public JwtTokenFilter jwtTokenFilter(UserSrv userSrv, JwtProvider jwtTokenProvider) {
        return new JwtTokenFilter(userSrv, jwtTokenProvider);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserSrv userSrv, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userSrv);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtTokenFilter jwtTokenFilter) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).httpBasic(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/auth/login")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/clientes/v1/crear")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                        //  rutas por rol

                        .requestMatchers(new AntPathRequestMatcher("clientes/v1/crear")).hasAnyRole("USER", "ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("empleados/v1/crear")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("prestamo/v1/aprobar")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("clientes/v1/actualizar/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("clientes/v1/lista")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("clientes/v1/elimina/**")).hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("prestamo/v1/lista/en-proceso")).hasRole("ADMIN")


                );

        //
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
