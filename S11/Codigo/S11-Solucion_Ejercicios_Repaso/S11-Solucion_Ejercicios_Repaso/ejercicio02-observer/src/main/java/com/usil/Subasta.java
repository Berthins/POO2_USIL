package com.usil;

import java.util.ArrayList;
import java.util.List;

//Sujeto: La subasta, es valida las ofertas y notifica a los observadores
public class Subasta {
    private String producto;
    private double mejorOferta;
    private String mejorPostor = "nadie";
    private List<Observador> observadores = new ArrayList<Observador>();

    public Subasta(String producto, double precioBase) {
        this.producto = producto;
        this.mejorOferta = precioBase;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void ofertar(String postor, double monto){
        double minimo = mejorOferta * 1.05;//al menos 5% mas que la mejor oferta

        if(monto < minimo){
            System.out.println("Oferta rechazada: debe ser al menos 5% más que la mejor oferta");
            return;
        }

        double ofertaAnterior = mejorOferta;
        mejorOferta = monto;
        mejorPostor = postor;
        notificarObservadores(ofertaAnterior);

    }

    private void notificarObservadores(double ofertaAnterior){
        for(Observador observador : observadores){
            observador.actualizar(mejorPostor, mejorOferta, ofertaAnterior);
        }
    }

    public void cerrar(){
        System.out.println("Subasta cerrada: Mejor Postor-> "+ mejorPostor +"con S/."+mejorOferta);
    }
}
