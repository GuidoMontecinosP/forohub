package com.aluracursos.challenge.forohub.forohub.repositorio;

import com.aluracursos.challenge.forohub.forohub.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombre(String nombre);
}
