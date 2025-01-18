package com.aluracursos.challenge.forohub.forohub.servicio;

import com.aluracursos.challenge.forohub.forohub.dto.TopicoDTO;
import com.aluracursos.challenge.forohub.forohub.excepciones.UsuarioNoEncontradoException;
import com.aluracursos.challenge.forohub.forohub.modelo.Curso;
import com.aluracursos.challenge.forohub.forohub.modelo.Topico;
import com.aluracursos.challenge.forohub.forohub.modelo.Usuario;
import com.aluracursos.challenge.forohub.forohub.repositorio.CursoRepositorio;
import com.aluracursos.challenge.forohub.forohub.repositorio.TopicoRepositorio;
import com.aluracursos.challenge.forohub.forohub.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoServicio {

    @Autowired
    private TopicoRepositorio topicoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public TopicoDTO registrarTopico(TopicoDTO topicoDTO) {
        // Usar el correo electrónico del autor
        String correoAutor = topicoDTO.autor();  // Ahora es un String

        // Buscar el autor por correo electrónico
        Usuario autor = usuarioRepositorio.findByCorreoElectronico(correoAutor)
                .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado"));

        // Buscar el curso por nombre
        Curso curso = cursoRepositorio.findByNombre(topicoDTO.curso())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        // Crear y persistir el nuevo tópico
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.titulo());
        topico.setMensaje(topicoDTO.mensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);

        Topico topicoGuardado = topicoRepositorio.save(topico);

        // Convertir a TopicoDTO antes de devolver
        return new TopicoDTO(
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getAutor().getCorreoElectronico(),  // Solo correo del autor
                topicoGuardado.getCurso().getNombre()
        );
    }

    // Cambiar este método para devolver una lista de TopicoDTO
    public List<TopicoDTO> listarTopicos() {
        return topicoRepositorio.findAll().stream()
                .map(topico -> new TopicoDTO(
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getAutor().getCorreoElectronico(),  // Solo correo del autor
                        topico.getCurso().getNombre()
                ))
                .collect(Collectors.toList());
    }

    // Cambiar este método para devolver TopicoDTO en lugar de Topico
    public TopicoDTO obtenerDetalleTopico(Long id) {
        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));

        return new TopicoDTO(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getCorreoElectronico(),  // Solo correo del autor
                topico.getCurso().getNombre()
        );
    }

    // Cambiar este método para devolver TopicoDTO en lugar de Topico
    public TopicoDTO actualizarTopico(Long id, TopicoDTO topicoDTO) {
        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));

        topico.setTitulo(topicoDTO.titulo());
        topico.setMensaje(topicoDTO.mensaje());

        Topico topicoActualizado = topicoRepositorio.save(topico);

        // Convertir a TopicoDTO antes de devolver
        return new TopicoDTO(
                topicoActualizado.getTitulo(),
                topicoActualizado.getMensaje(),
                topicoActualizado.getAutor().getCorreoElectronico(),  // Solo correo del autor
                topicoActualizado.getCurso().getNombre()
        );
    }

    public void eliminarTopico(Long id) {
        Topico topico = topicoRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tópico no encontrado"));

        topicoRepositorio.delete(topico);
    }
}