package com.example.proyectbiblioteca.utils;

import com.example.proyectbiblioteca.collections.Recurso;
import com.example.proyectbiblioteca.model_dto.RecursoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Mapper {

    public Function<RecursoDTO, Recurso> mapperRecursoDTOToEntity(){
        return recursoDTO->{
            var newRecurso = new Recurso();
            newRecurso.setCodigo(recursoDTO.getCodigo());
            newRecurso.setTitulo(recursoDTO.getTitulo());
            newRecurso.setTipo(recursoDTO.getTitulo());
            newRecurso.setDescripcion(recursoDTO.getDescripcion());
            newRecurso.setAutor(recursoDTO.getAutor());
            newRecurso.setTipo(recursoDTO.getTitulo());
            newRecurso.setTematica(recursoDTO.getTematica());
            newRecurso.setEstaPrestado(null);
            newRecurso.setFechaPrestamo(null);
            return newRecurso;
        };
    }


}
