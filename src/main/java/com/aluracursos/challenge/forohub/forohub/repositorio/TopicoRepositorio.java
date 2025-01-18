package com.aluracursos.challenge.forohub.forohub.repositorio;

import com.aluracursos.challenge.forohub.forohub.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTitulo(String titulo);
}