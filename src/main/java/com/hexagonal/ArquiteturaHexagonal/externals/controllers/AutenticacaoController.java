package com.hexagonal.ArquiteturaHexagonal.externals.controllers;

import com.hexagonal.ArquiteturaHexagonal.core.shared.userDto.LoginDto;
import com.hexagonal.ArquiteturaHexagonal.externals.auth.dto.DadosTokenJWT;
import com.hexagonal.ArquiteturaHexagonal.externals.auth.jwt.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody LoginDto dados){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
        Authentication authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken(authentication);
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }
}
