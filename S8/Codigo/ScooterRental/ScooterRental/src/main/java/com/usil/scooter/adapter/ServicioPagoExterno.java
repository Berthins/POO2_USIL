package com.usil.scooter.adapter;

/**
 * Simula una libreria de TERCEROS que no podemos modificar.
 * Su API es distinta a la nuestra: recibe centimos (long) y responde con un codigo numerico.
 */
public class ServicioPagoExterno {

    /** Devuelve 0 = aprobado, 1 = tarjeta invalida, 2 = monto invalido. */
    public int procesarTransaccion(String numeroTarjeta, long centimos) {
        if (numeroTarjeta == null || numeroTarjeta.length() != 16 || !numeroTarjeta.chars().allMatch(Character::isDigit)) {
            return 1;
        }
        if (centimos <= 0) {
            return 2;
        }
        return 0;
    }
}
