package pe.usil.pedido.adapter;

public class LegacyBillingSystem {

    public boolean facturar(String nombreMayusculas, int montoEnCentavos) {
        return !nombreMayusculas.isBlank() && montoEnCentavos > 0;
    }
}
