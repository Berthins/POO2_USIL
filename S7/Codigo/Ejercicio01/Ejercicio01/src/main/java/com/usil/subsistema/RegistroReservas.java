package com.usil.subsistema;

import com.usil.modelo.Reserva;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroReservas {

    private final List<Reserva> reservas = new ArrayList<>();

    public void agregar(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> obtenerTodas() {
        return Collections.unmodifiableList(reservas);
    }
}
