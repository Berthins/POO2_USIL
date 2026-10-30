package com.usil;

//Observador: todos los que quieren enterarse de una nueva oferta
public interface Observador {
    void actualizar(String postor, double oferta, double ofertaAnterior);
}
