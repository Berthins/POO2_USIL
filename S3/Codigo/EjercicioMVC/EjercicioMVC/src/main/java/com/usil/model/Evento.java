package com.usil.model;

public class Evento {

    private int id;
    private String nombre;
    private String fecha;
    private String lugar;
    private Categoria categoria;

    public Evento() {
    }

    public Evento(int id, String nombre, String fecha, String lugar, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fecha=" + fecha
                + ", lugar=" + lugar + ", categoria=" + (categoria != null ? categoria.getNombre() : "-") + '}';
    }

}
