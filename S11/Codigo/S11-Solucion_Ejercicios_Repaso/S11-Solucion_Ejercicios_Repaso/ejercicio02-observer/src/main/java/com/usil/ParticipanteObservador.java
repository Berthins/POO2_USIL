package com.usil;


public class ParticipanteObservador implements Observador {
    private String nombre;
    private double presupuesto;

    public ParticipanteObservador(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }


    @Override
    public void actualizar(String postor, double oferta, double ofertaAnterior) {
        if(postor.equals(this.nombre)){
            System.out.println(this.nombre + ": tu oferta lidera");
        } else if (oferta > presupuesto) {
            System.out.println(nombre + " no puede superar su presupuesto de " + presupuesto);
        } else {
            System.out.println(nombre + " ha sido notificado de la nueva oferta de " + postor
                    + ": " + oferta);
        }
    }
}
