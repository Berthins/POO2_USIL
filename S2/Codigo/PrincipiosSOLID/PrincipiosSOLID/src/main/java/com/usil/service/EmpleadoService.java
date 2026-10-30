package com.usil.service;

import com.usil.model.Empleado;

public class EmpleadoService {
    
    //Regla de negocio
    public double calcularPagoEmpleado(Empleado empleado) {
        //Polimorfismo
        return empleado.calcularPago();
    }   
    
    
}
