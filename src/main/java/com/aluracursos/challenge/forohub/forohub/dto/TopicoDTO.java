package com.aluracursos.challenge.forohub.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,  // Ahora es solo String (el correo)
        @NotBlank String curso
) {
}