package com.aluracursos.challenge.forohub.forohub.servicio;

import com.aluracursos.challenge.forohub.forohub.modelo.Usuario;
import com.aluracursos.challenge.forohub.forohub.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        return usuarioRepositorio.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }


    public Usuario cargarUsuarioPorCorreo(String correoElectronico) {
        return (Usuario) loadUserByUsername(correoElectronico);
    }


}