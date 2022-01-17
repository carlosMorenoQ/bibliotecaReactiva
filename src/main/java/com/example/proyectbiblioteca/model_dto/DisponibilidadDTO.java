package com.example.proyectbiblioteca.model_dto;

import java.util.Date;

public class DisponibilidadDTO {

    private Boolean estaDisponible;
    private Date fechaPrestamo;
    private String Observacion;

    public DisponibilidadDTO() {
    }

    public DisponibilidadDTO(Boolean estaDisponible,
                             Date fechaPrestamo,
                             String observacion) {
        this.estaDisponible = estaDisponible;
        this.fechaPrestamo = fechaPrestamo;
        Observacion = observacion;
    }

    public Boolean getEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(Boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }
}
