package com.usil.subsistema;

import com.usil.modelo.Reserva;

public class ValidadorReserva {

    public boolean esValida(Reserva reserva) {
        return noVacio(reserva.getCodigo())
                && noVacio(reserva.getDestino())
                && noVacio(reserva.getCliente())
                && reserva.getNumeroPersonas() > 0;
    }

    private boolean noVacio(String texto) {
        return texto != null && !texto.isBlank();
    }
}
