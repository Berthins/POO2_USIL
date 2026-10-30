package com.usil.model;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private Genero genero;
    private double precio;
    private int stock;

    public Libro(String codigo, String titulo, String autor, Genero genero, double precio, int stock) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    
}
