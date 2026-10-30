package com.usil;

import com.usil.model.Desarrollador;
import com.usil.model.Empleado;
import com.usil.model.Gerente;
import com.usil.model.Practicante;
import com.usil.service.EmpleadoService;


public class PrincipiosSOLID {

    public static void main(String[] args) {
        EmpleadoService service = new EmpleadoService();
        
        Empleado gerente = new Gerente("Juan", "Gerente", 5000);
        Empleado desarrollador = new Desarrollador("Ana", "Desarrollador", 3000);
        Empleado practicante = new Practicante("Luis", "Practicante", 1000);
        
        double pagoGerente = service.calcularPagoEmpleado(gerente);
        double pagoDesarrollador = service.calcularPagoEmpleado(desarrollador);
        double pagoPracticante = service.calcularPagoEmpleado(practicante);
        
        System.out.println("Pago de Gerente:"+pagoGerente);
        System.out.println("Pago de Desarrollador:"+pagoDesarrollador);
        System.out.println("Pago de Practicante:"+pagoPracticante);
        
    }
}
