package com.usil;

public class RegimenGeneral implements SueldoStrategy{
    @Override
    public double calcularNeto(double sueldo, int horasExtra) {
        double valorHora = sueldo / 240;
        double pagoHorasExtras = horasExtra * valorHora * 1.25;
        double sueldoBruto = sueldo + horasExtra * valorHora * 1.25;
        double pension = sueldoBruto*0.13;
        double renta = 0;

        if(sueldoBruto > 4000){
            renta = (sueldoBruto - 4000 ) *0.08;
        }

        return sueldoBruto - pension - renta;
    }
}
