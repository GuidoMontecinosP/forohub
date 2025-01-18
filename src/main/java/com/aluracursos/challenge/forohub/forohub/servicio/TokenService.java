package com.aluracursos.challenge.forohub.forohub.servicio;

import com.aluracursos.challenge.forohub.forohub.modelo.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String generarToken(Usuario usuario) {
        return JWT.create()
                .withSubject(usuario.getCorreoElectronico())
                .withExpiresAt(new Date(System.currentTimeMillis() + Long.parseLong(expiration)))
                .sign(Algorithm.HMAC256(secret));
    }

    public String obtenerUsuarioDesdeToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getSubject();
    }
}