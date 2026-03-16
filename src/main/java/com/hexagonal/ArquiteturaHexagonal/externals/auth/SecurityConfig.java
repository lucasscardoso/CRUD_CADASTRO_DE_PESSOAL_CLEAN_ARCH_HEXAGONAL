package com.hexagonal.ArquiteturaHexagonal.externals.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Obrigatório desabilitar para testar POST no Postman
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios/criar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/buscar").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuarios/buscar/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/deletar/**").permitAll()
                        .anyRequest().authenticated() // Bloqueia o resto (segurança)
                )
                .build();
    }
}
