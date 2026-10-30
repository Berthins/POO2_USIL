package com.usil.scooter.builder;

import com.usil.scooter.model.Scooter;

public class ScooterBuilder {

    private String marca;
    private String modelo;
    private double tarifaPorMinuto;

    public ScooterBuilder marca(String marca) { this.marca = marca; return this; }

    public ScooterBuilder modelo(String modelo) { this.modelo = modelo; return this; }

    public ScooterBuilder tarifaPorMinuto(double tarifaPorMinuto) { this.tarifaPorMinuto = tarifaPorMinuto; return this; }

    public Scooter build() {
        if (marca == null || marca.isBlank() || modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("Marca y modelo son obligatorios.");
        }
        if (tarifaPorMinuto <= 0) {
            throw new IllegalArgumentException("La tarifa por minuto debe ser mayor que cero.");
        }
        return new Scooter(marca.trim(), modelo.trim(), tarifaPorMinuto);
    }
}
