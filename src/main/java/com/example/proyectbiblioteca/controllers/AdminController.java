package com.example.proyectbiblioteca.controllers;

import com.example.proyectbiblioteca.model_dto.DisponibilidadDTO;
import com.example.proyectbiblioteca.model_dto.MensajeDTO;
import com.example.proyectbiblioteca.usecases.AdminRecursoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRecursoUseCase adminRecursoUseCase;

    @GetMapping("/disponibilidad/{codigoRecurso}")
    public Mono<DisponibilidadDTO> consultarDisponibilidad(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.consultarDisponibilidad(codigoRecurso);
    }

    @PutMapping("/prestar/{codigoRecurso}")
    public Mono<MensajeDTO> prestarRecurso(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.prestarRecurso(codigoRecurso);
    }

    @PutMapping("/devolver/{codigoRecurso}")
    public Mono<MensajeDTO> devolverRecurso(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.devolverRecurso(codigoRecurso);
    }



}
