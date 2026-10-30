package com.usil;

//Calcular la comision de la casa: 5% de la oferta
public class ComisionObservador implements Observador {
    @Override
    public void actualizar(String postor, double oferta, double ofertaAnterior) {
        double comision = oferta * 0.05;
        System.out.println("Comision de la casa: " + comision);
    }
}
