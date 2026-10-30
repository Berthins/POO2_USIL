package com.usil.model;

public class Desarrollador extends Empleado{    
    public Desarrollador(String nombre, String tipo, double salario) {
        super(nombre, tipo, salario);
    }    

    @Override
    public double calcularPago() {
         return getSalario();
    }
}
