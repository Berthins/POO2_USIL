package com.usil;

public class RegimenHonorarios implements SueldoStrategy{
    @Override
    public double calcularNeto(double sueldo, int horasExtra) {
        double retencion = 0;
        if(sueldo >= 3200){
            retencion = sueldo  * 0.08;
        }
        return sueldo - retencion;
    }
}
