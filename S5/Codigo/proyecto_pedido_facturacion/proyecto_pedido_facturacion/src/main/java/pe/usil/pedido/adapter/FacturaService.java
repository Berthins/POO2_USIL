package pe.usil.pedido.adapter;

import pe.usil.pedido.model.Cliente;

public interface FacturaService {

    void emitirFactura(Cliente cliente, double monto);
}
