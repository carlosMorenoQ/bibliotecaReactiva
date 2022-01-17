package com.example.proyectbiblioteca.repositories;

import com.example.proyectbiblioteca.collections.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends MongoRepository<Recurso, String> {



    Recurso findByCodigo(String codido);
//
//    List<Recurso> findByTipo(String tipoRecurso);
//
//    List<Recurso> findByTematica(String tematica);
//
//    List<Recurso> findByTipoAndTematica(String tipo, String tematica);

}
