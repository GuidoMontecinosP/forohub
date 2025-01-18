package com.aluracursos.challenge.forohub.forohub.controlador;

import com.aluracursos.challenge.forohub.forohub.dto.LoginDTO;
import com.aluracursos.challenge.forohub.forohub.modelo.Usuario;
import com.aluracursos.challenge.forohub.forohub.servicio.TokenService;
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
public class AuthControlador {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> autenticar(@RequestBody LoginDTO request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(), request.getContrasena()));
        Usuario usuario = (Usuario) auth.getPrincipal();
        String token = tokenService.generarToken(usuario);
        return ResponseEntity.ok(token);
    }
}