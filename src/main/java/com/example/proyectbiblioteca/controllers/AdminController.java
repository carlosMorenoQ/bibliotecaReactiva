package com.example.proyectbiblioteca.controllers;

import com.example.proyectbiblioteca.model_dto.DisponibilidadDTO;
import com.example.proyectbiblioteca.model_dto.MensajeDTO;
import com.example.proyectbiblioteca.usecases.AdminRecursoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRecursoUseCase adminRecursoUseCase;

    @GetMapping("/disponibilidad/{codigoRecurso}")
    public DisponibilidadDTO consultarDisponibilidad(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.consultarDisponibilidad(codigoRecurso);
    }

    @PutMapping("/prestar/{codigoRecurso}")
    public MensajeDTO prestarRecurso(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.prestarRecurso(codigoRecurso);
    }

    @PutMapping("/devolver/{codigoRecurso}")
    public MensajeDTO devolverRecurso(
            @PathVariable("codigoRecurso") String codigoRecurso) {
        return adminRecursoUseCase.devolverRecurso(codigoRecurso);
    }



}
