package com.usil.scooter.adapter;

/** Interfaz propia del sistema para cobrar (la que espera el resto del codigo). */
public interface PasarelaPago {

    /** Cobra el monto con la tarjeta. Lanza IllegalArgumentException si el cobro es rechazado. */
    void cobrar(double monto, String tarjeta);
}
