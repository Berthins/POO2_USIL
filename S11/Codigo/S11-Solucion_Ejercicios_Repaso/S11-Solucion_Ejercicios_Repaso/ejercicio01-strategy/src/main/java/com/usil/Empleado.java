package com.usil;

public class Empleado {

    private String nombre;
    private double sueldo;
    private int horasExtras;
    private SueldoStrategy estrategia;

    public Empleado(String nombre, double sueldo, int horasExtras, SueldoStrategy estrategia) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.horasExtras = horasExtras;
        this.estrategia = estrategia;
    }

    public String getNombre() {
        return nombre;
    }

    public double calcularSueldoNeto(){
        return estrategia.calcularNeto(sueldo, horasExtras);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", horasExtras=" + horasExtras +
                ", estrategia=" + estrategia.calcularNeto(sueldo, horasExtras) +
                '}';
    }
}
