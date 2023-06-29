package org.example.Ejercicio7;

import java.util.Date;
/*
EJERCICIO 7:
        Desarrollar un programa que permita a los usuarios almacenar a traves de la consola
        información sobre sus tareas. La aplicación permite a los usuarios crear tareas,
        asignarles categorias, establecer fechas limites de entrega.
        Implementar al menos 2 clases que usen herencia de clases entre si
        Hacerlo para al menos 5 tareas

        ENTREGABLE:
        - Codigo del proyecto.
        */
public abstract class TareaBase {
    private String titulo;
    private String descripcion;
    private String fechaLimite;
    private Date fechaCreacion;
    private Categoria categoria;

    private Usuario asignado;

    public TareaBase() {
    }

    public TareaBase(String titulo, String descripcion, String fechaLimite, Categoria categoria,Usuario usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = new Date();
        this.asignado=usuario;
        this.categoria = categoria;
    }

    public Usuario getAsignado() {
        return asignado;
    }

    public void setAsignado(Usuario asignado) {
        this.asignado = asignado;
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

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
