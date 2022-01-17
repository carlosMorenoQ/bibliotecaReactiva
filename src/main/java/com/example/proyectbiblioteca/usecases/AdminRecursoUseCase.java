package com.example.proyectbiblioteca.usecases;


import com.example.proyectbiblioteca.model_dto.DisponibilidadDTO;
import com.example.proyectbiblioteca.model_dto.MensajeDTO;
import com.example.proyectbiblioteca.repositories.RecursoRepository;
import com.example.proyectbiblioteca.utils.Mapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class AdminRecursoUseCase {

    private final RecursoRepository recursoRepository;
    private final Mapper mapper;


    public AdminRecursoUseCase(RecursoRepository recursoRepository,
                               Mapper mapper) {
        this.recursoRepository = recursoRepository;
        this.mapper = mapper;
    }

    public Mono<DisponibilidadDTO> consultarDisponibilidad(String codigoRecurso){
        var disponibilidad = new DisponibilidadDTO();
        var recurso = recursoRepository.findByCodigo(codigoRecurso).block();

        if(recurso == null){
            disponibilidad.setEstaDisponible(false);
            disponibilidad.setFechaPrestamo(null);
            disponibilidad.setObservacion("Recurso solicitado no existe");
        }else if(Boolean.TRUE.equals(recurso.getEstaPrestado())){
            disponibilidad.setEstaDisponible(false);
            disponibilidad.setFechaPrestamo(recurso.getFechaPrestamo());
            disponibilidad.setObservacion("Recurso solicitado ya esta prestado");
        }else {
            disponibilidad.setEstaDisponible(true);
        }

        return Mono.just(disponibilidad);
    }

    public Mono<MensajeDTO> prestarRecurso(String codigoRecurso){
        var estadoPrestamo = consultarDisponibilidad(codigoRecurso).block();
        var mensajeDTO =new MensajeDTO();

        if (Boolean.TRUE.equals(estadoPrestamo.getEstaDisponible())){
            var recurso = recursoRepository.findByCodigo(codigoRecurso).block();
            recurso.setEstaPrestado(true);
            recurso.setFechaPrestamo(new Date());
            recursoRepository.save(recurso);
            mensajeDTO.setMensaje("El recurso se a prestado con exito");
        }else{
            mensajeDTO.setMensaje("El recurso no se encuentra disponible o ya esta en prestamo");
        }
        return Mono.just(mensajeDTO);
    }


    public Mono<MensajeDTO> devolverRecurso(String codigoRecurso){
        var recurso = recursoRepository.findByCodigo(codigoRecurso).block();
        var mensajeDTO =new MensajeDTO();

        if(recurso == null){
            mensajeDTO.setMensaje("EL recurso no existe");
        }else if (recurso.getEstaPrestado()){
            recurso.setEstaPrestado(false);
            recurso.setFechaPrestamo(null);
            recursoRepository.save(recurso);
            mensajeDTO.setMensaje("Recurso devuelto con exito");
        }else{
            mensajeDTO.setMensaje("El recurso no se encuentra prestado");
        }

        return Mono.just(mensajeDTO);
    }


}
