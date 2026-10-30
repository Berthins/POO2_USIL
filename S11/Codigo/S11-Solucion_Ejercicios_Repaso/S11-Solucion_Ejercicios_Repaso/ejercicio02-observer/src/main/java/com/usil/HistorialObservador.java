package com.usil;

//Cuenta las ofertas y muestra cuanto se incremento porcentualmente (%)
public class HistorialObservador implements Observador {
    private int numero = 0;

    @Override
    public void actualizar(String postor, double oferta, double ofertaAnterior) {
        numero++;
        double incremento = ((oferta - ofertaAnterior) / ofertaAnterior) * 100;
        System.out.println("Numero de ofertas: " + numero);
        System.out.println("Incremento porcentual: " + incremento + "%");
    }
}
