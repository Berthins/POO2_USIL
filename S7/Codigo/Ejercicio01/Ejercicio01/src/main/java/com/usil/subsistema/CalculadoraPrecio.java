package com.usil.subsistema;

import com.usil.modelo.Reserva;

public class CalculadoraPrecio {

    private static final int PERSONAS_GRUPO = 4;
    private static final double DESCUENTO_GRUPO = 0.10;

    public double calcularTotal(Reserva reserva) {
        double total = reserva.getNumeroPersonas() * reserva.getPrecioPorPersona();
        if (reserva.getNumeroPersonas() >= PERSONAS_GRUPO) {
            total = total - total * DESCUENTO_GRUPO;
        }
        return total;
    }
}
