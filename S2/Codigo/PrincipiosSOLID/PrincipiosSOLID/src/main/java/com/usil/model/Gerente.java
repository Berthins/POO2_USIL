package com.usil.model;

public class Gerente extends Empleado{
    private static final double BONO_GERENTE = 1000;
    
    public Gerente(String nombre, String tipo, double salario) {
        super(nombre, tipo, salario);
    }

    @Override
    public double calcularPago() {
          return getSalario() + BONO_GERENTE;
    }
    
}
