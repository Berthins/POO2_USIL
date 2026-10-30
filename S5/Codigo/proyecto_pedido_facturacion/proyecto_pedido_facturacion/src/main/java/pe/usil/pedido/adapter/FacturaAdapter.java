package pe.usil.pedido.adapter;

import pe.usil.pedido.model.Cliente;

public class FacturaAdapter implements FacturaService {

    private final LegacyBillingSystem legacyBillingSystem;

    public FacturaAdapter(LegacyBillingSystem legacyBillingSystem) {
        this.legacyBillingSystem = legacyBillingSystem;
    }

    @Override
    public void emitirFactura(Cliente cliente, double monto) {
        String nombreMayusculas = cliente.getNombre().toUpperCase();
        int montoEnCentavos = (int) Math.round(monto * 100);

        boolean exito = legacyBillingSystem.facturar(nombreMayusculas, montoEnCentavos);
        if (!exito) {
            throw new IllegalStateException("No se pudo generar la factura para " + cliente.getNombre());
        }
    }
}
