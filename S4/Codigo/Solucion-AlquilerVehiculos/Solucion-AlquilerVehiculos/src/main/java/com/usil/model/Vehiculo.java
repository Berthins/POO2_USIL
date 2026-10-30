package com.usil.model;

/**
 * Modelo base de un vehiculo, con sus 5 atributos obligatorios.
 * Sedan y Suv son las subclases (herencia) que representan cada tipo
 * y solo se crean a traves de VehiculoFactory.
 */
public abstract class Vehiculo {

    private final String placa;
    private final String marca;
    private final String modelo;
    private final int anio;
    private final double tarifaDiaria;

    protected Vehiculo(String placa, String marca, String modelo, int anio, double tarifaDiaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tarifaDiaria = tarifaDiaria;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] %s %s (%d) - %s - S/ %.2f/dia",
                placa, marca, modelo, anio, getTipo(), tarifaDiaria);
    }

}
