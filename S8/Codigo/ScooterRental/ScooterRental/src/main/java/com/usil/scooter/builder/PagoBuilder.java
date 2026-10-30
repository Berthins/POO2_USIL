package com.usil.scooter.builder;

import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Pago;
import java.time.LocalDateTime;

public class PagoBuilder {

    private Alquiler alquiler;
    private String tarjeta;

    public PagoBuilder alquiler(Alquiler alquiler) { this.alquiler = alquiler; return this; }

    public PagoBuilder tarjeta(String tarjeta) { this.tarjeta = tarjeta; return this; }

    /** El monto sale del alquiler, la fecha es ahora y de la tarjeta solo se guardan los ultimos 4 digitos. */
    public Pago build() {
        if (alquiler == null) {
            throw new IllegalArgumentException("No hay un alquiler para pagar.");
        }
        if (tarjeta == null || tarjeta.trim().length() < 4) {
            throw new IllegalArgumentException("La tarjeta es obligatoria.");
        }
        String digitos = tarjeta.trim();
        String enmascarada = "**** " + digitos.substring(digitos.length() - 4);
        return new Pago(alquiler, alquiler.getMonto(), enmascarada, LocalDateTime.now());
    }
}
