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
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody LoginDto dados){
//        System.out.println("CHEGOU NO CONTROLLER");
//        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
//        Authentication authentication = manager.authenticate(authenticationToken);
//        var tokenJWT = tokenService.gerarToken(authentication);
//        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        try {
            System.out.println("Tentando autenticar: " + dados.getEmail());
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());

            // Se o erro acontece aqui, ele vai para o CATCH
            Authentication authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            System.out.println("ERRO NA AUTENTICAÇÃO: " + e.getMessage());
            e.printStackTrace(); // Isso vai mostrar a pilha de erro colorida no console
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }
}
