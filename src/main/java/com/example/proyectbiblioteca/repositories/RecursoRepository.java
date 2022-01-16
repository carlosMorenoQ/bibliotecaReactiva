package com.example.proyectbiblioteca.repositories;

import com.example.proyectbiblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String> {

    Recurso findByCodigo(String codido);

    List<Recurso> findByTipo(String tipoRecurso);

    List<Recurso> findByTematica(String tematica);

    List<Recurso> findByTipoAndTematica(String tipo, String tematica);

}
