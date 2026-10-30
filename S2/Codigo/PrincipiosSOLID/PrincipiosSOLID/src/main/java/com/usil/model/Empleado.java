package com.usil.model;

public abstract class Empleado {
    private String nombre;
    private String tipo;
    private double salario;

    public Empleado(String nombre, String tipo, double salario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract double calcularPago();
    
            
    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", tipo=" + tipo + ", salario=" + salario + '}';
    }
}
