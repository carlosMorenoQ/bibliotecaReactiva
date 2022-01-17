package com.example.proyectbiblioteca.utils;

import com.example.proyectbiblioteca.collections.Recurso;
import com.example.proyectbiblioteca.model_dto.RecursoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Mapper {

    public Function<RecursoDTO, Recurso> mapperRecursoDTOToEntity(String id) {
        return recursoDTO -> {
            var newRecurso = new Recurso();
            newRecurso.setId(id);
            newRecurso.setCodigo(recursoDTO.getCodigo());
            newRecurso.setTitulo(recursoDTO.getTitulo());
            newRecurso.setDescripcion(recursoDTO.getDescripcion());
            newRecurso.setAutor(recursoDTO.getAutor());
            newRecurso.setTipo(recursoDTO.getTipo());
            newRecurso.setTematica(recursoDTO.getTematica());
            newRecurso.setEstaPrestado(false);
            newRecurso.setFechaPrestamo(null);
            return newRecurso;
        };
    }

    public Function<Recurso, RecursoDTO> mapperEntityToRecursoDTO() {
        return recurso -> (new RecursoDTO(
                recurso.getId(),
                recurso.getCodigo(),
                recurso.getTitulo(),
                recurso.getDescripcion(),
                recurso.getAutor(),
                recurso.getTipo(),
                recurso.getTematica(),
                recurso.getEstaPrestado(),
                recurso.getFechaPrestamo()
        ));
    }


}
