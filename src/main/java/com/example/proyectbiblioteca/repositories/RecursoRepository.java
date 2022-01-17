package com.example.proyectbiblioteca.repositories;

import com.example.proyectbiblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface RecursoRepository extends ReactiveCrudRepository<Recurso, String> {


    Mono<Recurso> findByCodigo(String codido);
//
//    List<Recurso> findByTipo(String tipoRecurso);
//
//    List<Recurso> findByTematica(String tematica);
//
//    List<Recurso> findByTipoAndTematica(String tipo, String tematica);

}
