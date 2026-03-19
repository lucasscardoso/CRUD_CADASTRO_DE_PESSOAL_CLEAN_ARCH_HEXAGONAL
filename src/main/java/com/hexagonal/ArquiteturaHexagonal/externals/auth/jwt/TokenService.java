package com.hexagonal.ArquiteturaHexagonal.externals.auth.jwt;

import com.hexagonal.ArquiteturaHexagonal.externals.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    private String secret = "e9a3b6c7d8e9f0a1b2c3d4e5f6a7b8c97d8e4e5f7d8e9f0a1b2c3d4e5";
    private long expiration = 3600000;

    public String gerarToken(Authentication authentication){
        UserEntity usuarioLogado = (UserEntity) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + expiration);

        assert usuarioLogado != null;
        return Jwts.builder()
                .setIssuer("API Arquitetura Hexagonal")
                .setSubject(usuarioLogado.getEmail())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSubject(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
