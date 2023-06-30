package org.example.ejercicio8;

public class Artista {
    private String nombre;
    private String genero;
    private Integer numeroCanciones;
    private Integer reproducciones;
    private Integer suscriptores;

    private Double gananciaTotal;



    public Artista(String nombre, String genero, Integer numeroCanciones, Integer reproducciones, Integer suscriptores) {
        this.nombre = nombre;
        this.genero = genero;
        this.numeroCanciones = numeroCanciones;
        this.reproducciones = reproducciones;
        this.suscriptores = suscriptores;
        this.gananciaTotal = reproducciones * 0.02;
    }

    @Override
    public String toString() {
        return "Artista: " +
                "nombre: " + nombre + '\'' +
                ", genero: " + genero + '\'' +
                ", numeroCanciones: " + numeroCanciones +
                ", reproducciones: " + reproducciones +
                ", suscriptores: " + suscriptores +
                ", gananciaTotal: " + gananciaTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(Integer numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public Integer getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(Integer reproducciones) {
        this.reproducciones = reproducciones;
    }

    public Integer getSuscriptores() {
        return suscriptores;
    }

    public void setSuscriptores(Integer suscriptores) {
        this.suscriptores = suscriptores;
    }

    public Double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(Double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }
}
