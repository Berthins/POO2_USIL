package com.usil;

public class RegimenMype implements SueldoStrategy{

    @Override
    public double calcularNeto(double sueldo, int horasExtra) {
        double valorHora = sueldo / 240;
        double pagoHorasExtras = horasExtra * valorHora * 1.25;
        double sueldoBruto = sueldo + pagoHorasExtras;
        return sueldoBruto - sueldoBruto * 0.13;
    }
}
