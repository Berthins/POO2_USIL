package com.usil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Planilla planilla = new Planilla();

        for (int i= 1; i<=3; i++){
            System.out.print("Ingrese su nombre:");
            String nombre = sc.next();
            System.out.print("Ingrese su sueldo:");
            double sueldo = sc.nextDouble();
            System.out.print("Ingrese horas extras:");
            int horasExtras = sc.nextInt();
            System.out.print("Ingrese Regimen (1=General, 2=Mype, 3=Honorarios):");
            int regimen = sc.nextInt();

            SueldoStrategy estrategia;
            if(regimen==1){
                estrategia = new RegimenGeneral();
            }else if(regimen==2){
                estrategia = new RegimenMype();
            }else {
                estrategia = new RegimenHonorarios();
            }

            planilla.agregarEmpleado(new Empleado(nombre, sueldo, horasExtras, estrategia));
            System.out.println();
        }

        for (Empleado empleado : planilla.getEmpleados()) {
            System.out.println(empleado);
        }

        System.out.println("Total planilla:"+ planilla.calcularTotal());
        Empleado mejorEmpleado = planilla.mejorPagado();
        System.out.println("Mejor pagado: " + mejorEmpleado.getNombre());
    }
}