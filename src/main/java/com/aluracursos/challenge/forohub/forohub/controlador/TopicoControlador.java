package com.aluracursos.challenge.forohub.forohub.controlador;

import com.aluracursos.challenge.forohub.forohub.dto.TopicoDTO;
import com.aluracursos.challenge.forohub.forohub.servicio.TopicoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoControlador {

    @Autowired
    private TopicoServicio topicoServicio;

    @PostMapping
    public ResponseEntity<TopicoDTO> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO) {
        // Llamamos al servicio para registrar el tópico
        TopicoDTO responseDTO = topicoServicio.registrarTopico(topicoDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // Cambiar el método para devolver TopicoDTO en lugar de Topico
    @GetMapping
    public ResponseEntity<List<TopicoDTO>> listarTopicos() {
        return ResponseEntity.ok(topicoServicio.listarTopicos());
    }

    // Cambiar el método para devolver TopicoDTO en lugar de Topico
    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> obtenerDetalleTopico(@PathVariable Long id) {
        return ResponseEntity.ok(topicoServicio.obtenerDetalleTopico(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> actualizarTopico(@PathVariable Long id, @RequestBody @Valid TopicoDTO topicoDTO) {
        TopicoDTO updatedTopico = topicoServicio.actualizarTopico(id, topicoDTO);
        return ResponseEntity.ok(updatedTopico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoServicio.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}