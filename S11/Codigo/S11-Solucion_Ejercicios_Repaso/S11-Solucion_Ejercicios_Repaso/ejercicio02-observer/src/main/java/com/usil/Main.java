package com.usil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Subasta subasta = new Subasta("Laptop", 1000.0);

        subasta.agregarObservador(new HistorialObservador());
        subasta.agregarObservador(new ComisionObservador());
        subasta.agregarObservador(new ParticipanteObservador("Luis", 1250));
        subasta.agregarObservador(new ParticipanteObservador("Rosa", 1500));

        for (int i = 1; i <=5 ; i++) {
            System.out.println("Postor:");
            String postor = sc.next();
            System.out.println("Monto de la oferta:");
            double monto = sc.nextDouble();

            //Objeto subasta, que es el sujeto. Lanza la oferta que es la notificacion de un postor
            //con un monto  (oferta) para el producto es un Laptop
            subasta.ofertar(postor, monto);
        }

        subasta.cerrar();
    }
}