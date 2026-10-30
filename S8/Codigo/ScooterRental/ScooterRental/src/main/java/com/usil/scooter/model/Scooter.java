package com.usil.scooter.model;

public class Scooter {

    private int id;
    private String marca;
    private String modelo;
    private double tarifaPorMinuto;

    public Scooter(String marca, String modelo, double tarifaPorMinuto) {
        this.marca = marca;
        this.modelo = modelo;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getTarifaPorMinuto() { return tarifaPorMinuto; }

    public void setTarifaPorMinuto(double tarifaPorMinuto) { this.tarifaPorMinuto = tarifaPorMinuto; }

    @Override
    public String toString() {
        return id + " - " + marca + " " + modelo;
    }
}
