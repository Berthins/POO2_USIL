package com.usil.model;

public class Practicante extends Empleado{
     private static final double PORCE_PRACTICANTE = 0.5;
     
    public Practicante(String nombre, String tipo, double salario) {
        super(nombre, tipo, salario);
    }

    @Override
    public double calcularPago() {
        return getSalario() * PORCE_PRACTICANTE;
    }
    
    
}
