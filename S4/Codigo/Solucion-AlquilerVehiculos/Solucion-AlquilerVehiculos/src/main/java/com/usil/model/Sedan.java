package com.usil.model;

public class Sedan extends Vehiculo {

    private static final double TARIFA_DIARIA = 90.00;

    public Sedan(String placa, String marca, String modelo, int anio) {
        super(placa, marca, modelo, anio, TARIFA_DIARIA);
    }

    @Override
    public String getTipo() {
        return "Sedan";
    }

}
