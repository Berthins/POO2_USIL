package com.usil.scooter.adapter;

/** ADAPTER: convierte nuestra interfaz PasarelaPago a la API del servicio externo. */
public class PasarelaPagoAdapter implements PasarelaPago {

    private final ServicioPagoExterno servicioExterno = new ServicioPagoExterno();

    @Override
    public void cobrar(double monto, String tarjeta) {
        int codigo = servicioExterno.procesarTransaccion(tarjeta.trim(), Math.round(monto * 100));
        if (codigo == 1) {
            throw new IllegalArgumentException("Tarjeta invalida: escriba 16 digitos.");
        }
        if (codigo == 2) {
            throw new IllegalArgumentException("Monto invalido.");
        }
    }
}
