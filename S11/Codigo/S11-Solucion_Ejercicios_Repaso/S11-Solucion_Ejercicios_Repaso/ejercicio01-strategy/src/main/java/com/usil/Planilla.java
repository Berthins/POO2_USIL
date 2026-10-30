package com.usil;

import java.util.ArrayList;
import java.util.List;

public class Planilla {

    private List<Empleado> empleados = new ArrayList<Empleado>();

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public double calcularTotal(){
        double total = 0;
        for(Empleado empleado : empleados){
            total += empleado.calcularSueldoNeto();
        }

        return total;
    }

    public Empleado mejorPagado(){
        Empleado mejorEmpleado = empleados.get(0);
        for(Empleado empleado : empleados){
            if(empleado.calcularSueldoNeto() > mejorEmpleado.calcularSueldoNeto()){
                mejorEmpleado = empleado;
            }
        }
        return mejorEmpleado;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
