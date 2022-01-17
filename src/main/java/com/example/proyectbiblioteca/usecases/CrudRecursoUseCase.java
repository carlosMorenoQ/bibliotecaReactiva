package com.example.proyectbiblioteca.usecases;


import com.example.proyectbiblioteca.collections.Recurso;
import com.example.proyectbiblioteca.model_dto.RecursoDTO;
import com.example.proyectbiblioteca.repositories.RecursoRepository;
import com.example.proyectbiblioteca.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudRecursoUseCase {

    private final RecursoRepository recursoRepository;
    private final Mapper mapper;

    public CrudRecursoUseCase(RecursoRepository recursoRepository,
                              Mapper mapper) {
        this.recursoRepository = recursoRepository;
        this.mapper = mapper;
    }

    public RecursoDTO crearRecurso(RecursoDTO recursoDTO) {
        recursoDTO.setEstaPrestado(false);
        return mapper.mapperEntityToRecursoDTO()
                .apply(recursoRepository.save(
                        mapper.mapperRecursoDTOToEntity(null)
                                .apply(recursoDTO)));
    }

    public void eliminarRecurso(String idRecurso) {
        recursoRepository.deleteById(idRecurso);
    }


    public RecursoDTO actualizarRecurso(RecursoDTO recursoDTO) {
        return mapper.mapperEntityToRecursoDTO()
                .apply(recursoRepository.save(
                        mapper.mapperRecursoDTOToEntity(recursoDTO.getId())
                                .apply(recursoDTO)));
    }

    public List<RecursoDTO> obtenerRecursos() {
        return recursoRepository.findAll()
                .stream()
                .map(recurso -> mapper.mapperEntityToRecursoDTO().apply(recurso))
                .collect(Collectors.toList());
    }


}
