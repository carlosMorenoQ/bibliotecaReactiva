package com.example.proyectbiblioteca.usecases;


import com.example.proyectbiblioteca.model_dto.RecursoDTO;
import com.example.proyectbiblioteca.repositories.RecursoRepository;
import com.example.proyectbiblioteca.utils.Mapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CrudRecursoUseCase {

    private final RecursoRepository recursoRepository;
    private final Mapper mapper;

    public CrudRecursoUseCase(RecursoRepository recursoRepository,
                              Mapper mapper) {
        this.recursoRepository = recursoRepository;
        this.mapper = mapper;
    }

    public Mono<RecursoDTO> crearRecurso(RecursoDTO recursoDTO) {
        recursoDTO.setEstaPrestado(false);
        return recursoRepository.save(mapper.mapperRecursoDTOToEntity(null)
                .apply(recursoDTO)).map(recurso -> mapper.mapperEntityToRecursoDTO().apply(recurso));
    }

    public void eliminarRecurso(String idRecurso) {
        recursoRepository.deleteById(idRecurso);
    }

    public Mono<RecursoDTO> actualizarRecurso(RecursoDTO recursoDTO) {
        return recursoRepository.save(mapper.mapperRecursoDTOToEntity(recursoDTO.getId())
                .apply(recursoDTO)).map(recurso -> mapper.mapperEntityToRecursoDTO().apply(recurso));
    }

    public Flux<RecursoDTO> obtenerRecursos() {
        return recursoRepository.findAll()
                .map(recurso -> mapper.mapperEntityToRecursoDTO().apply(recurso));
    }


}
