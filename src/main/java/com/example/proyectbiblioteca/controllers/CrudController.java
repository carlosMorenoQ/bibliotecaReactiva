package com.example.proyectbiblioteca.controllers;

import com.example.proyectbiblioteca.collections.Recurso;
import com.example.proyectbiblioteca.model_dto.RecursoDTO;
import com.example.proyectbiblioteca.usecases.CrudRecursoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/recurso")
public class CrudController {

    @Autowired
    CrudRecursoUseCase crudRecursoUseCase;

    @PostMapping("/crear")
    public Mono<RecursoDTO> crear(@RequestBody RecursoDTO recursoDTO){
        return crudRecursoUseCase.crearRecurso(recursoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarRecurso(@PathVariable("id") String id){
        crudRecursoUseCase.eliminarRecurso(id);
    }

    @PutMapping("/actualizar")
    public Mono<RecursoDTO> actualizarRecurso(@RequestBody RecursoDTO recursoDTO){
        return crudRecursoUseCase.actualizarRecurso(recursoDTO);
    }

    @GetMapping("/recursos")
    public Flux<RecursoDTO> obtenerRecursos(){
        return crudRecursoUseCase.obtenerRecursos();
    }

}
