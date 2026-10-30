package com.usil.model;

public class Suv extends Vehiculo {

    private static final double TARIFA_DIARIA = 150.00;

    public Suv(String placa, String marca, String modelo, int anio) {
        super(placa, marca, modelo, anio, TARIFA_DIARIA);
    }

    @Override
    public String getTipo() {
        return "SUV";
    }

}
