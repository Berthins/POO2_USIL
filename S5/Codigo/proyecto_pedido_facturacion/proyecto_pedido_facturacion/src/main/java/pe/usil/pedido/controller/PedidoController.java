package pe.usil.pedido.controller;

import pe.usil.pedido.model.Cliente;
import pe.usil.pedido.model.Pedido;
import pe.usil.pedido.model.Reporte;
import pe.usil.pedido.adapter.FacturaService;
import pe.usil.pedido.facade.PedidoFacade;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private final PedidoFacade pedidoFacade;
    private final FacturaService facturaService;

    public PedidoController(PedidoFacade pedidoFacade, FacturaService facturaService) {
        this.pedidoFacade = pedidoFacade;
        this.facturaService = facturaService;
    }

    public Reporte registrarPedido(String nombreCliente, String producto, String cantidadTexto) {
        if (nombreCliente.isBlank() || producto.isBlank()) {
            return error("Completa cliente y producto.");
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadTexto.trim());
        } catch (NumberFormatException e) {
            return error("La cantidad debe ser un número entero.");
        }
        if (cantidad <= 0) {
            return error("La cantidad debe ser positiva.");
        }

        List<String> bitacora = new ArrayList<>();
        try {
            Cliente cliente = new Cliente(nombreCliente.trim());
            Pedido pedido = new Pedido(cliente, producto.trim(), cantidad);

            pedidoFacade.procesarPedido(pedido);
            bitacora.add("PedidoFacade calculó el total: S/ " + String.format("%.2f", pedido.getTotal()));

            facturaService.emitirFactura(cliente, pedido.getTotal());
            bitacora.add("FacturaAdapter emitió la factura.");

            return new Reporte(true, pedido, bitacora, null);
        } catch (RuntimeException e) {
            bitacora.add("ERROR: " + e.getMessage());
            return new Reporte(false, null, bitacora, e.getMessage());
        }
    }

    private Reporte error(String mensaje) {
        return new Reporte(false, null, List.of("ERROR: " + mensaje), mensaje);
    }
}
