package com.usil.scooter.builder;

import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Scooter;
import java.time.LocalDateTime;

public class AlquilerBuilder {

    private Scooter scooter;
    private String cliente;
    private long minutos;

    public AlquilerBuilder scooter(Scooter scooter) { this.scooter = scooter; return this; }

    public AlquilerBuilder cliente(String cliente) { this.cliente = cliente; return this; }

    public AlquilerBuilder minutos(long minutos) { this.minutos = minutos; return this; }

    public Alquiler build() {
        if (scooter == null) {
            throw new IllegalArgumentException("No hay un scooter elegido.");
        }
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El cliente es obligatorio.");
        }
        if (minutos <= 0) {
            throw new IllegalArgumentException("Los minutos deben ser mayores que cero.");
        }
        LocalDateTime inicio = LocalDateTime.now();
        return new Alquiler(scooter, cliente.trim(), inicio, inicio.plusMinutes(minutos));
    }
}
