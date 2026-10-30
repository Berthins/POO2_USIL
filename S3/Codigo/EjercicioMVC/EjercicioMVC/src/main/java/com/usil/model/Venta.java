package com.usil.model;

public class Venta{
    private int cantidad;
    private double precio;

    public Venta() {
    }

    public Venta(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double calcularSubtotal(){
        return this.precio * this.cantidad;
    }

    @Override
    public String toString() {
        return "Venta{" + "cantidad=" + cantidad + ", precio=" + precio + '}';
    }   
    
}
