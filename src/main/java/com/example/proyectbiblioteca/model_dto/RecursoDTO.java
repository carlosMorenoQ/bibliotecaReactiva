package com.example.proyectbiblioteca.model_dto;



import java.util.Date;

public class RecursoDTO {

    private String id;
    private String codigo;
    private String titulo;
    private String descripcion;
    private String autor;
    private String tipo;
    private String tematica;
    private Boolean estaPrestado;
    private Date fechaPrestamo;

    public RecursoDTO() {
    }

    public RecursoDTO(
                String codigo,
                String titulo,
                String descripcion,
                String autor,
                String tipo,
                String tematica) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public RecursoDTO(String id,
                      String codigo,
                      String titulo,
                      String descripcion,
                      String autor,
                      String tipo,
                      String tematica,
                      Boolean estaPrestado,
                      Date fechaPrestamo) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.tipo = tipo;
        this.tematica = tematica;
        this.estaPrestado = estaPrestado;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Boolean getEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(Boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }


}
