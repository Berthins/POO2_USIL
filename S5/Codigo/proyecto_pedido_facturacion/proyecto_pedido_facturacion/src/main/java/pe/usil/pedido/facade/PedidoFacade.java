package pe.usil.pedido.facade;

import pe.usil.pedido.model.Pedido;

public class PedidoFacade {

    private final InventarioService inventarioService;
    private final TributacionService tributacionService;

    public PedidoFacade(InventarioService inventarioService, TributacionService tributacionService) {
        this.inventarioService = inventarioService;
        this.tributacionService = tributacionService;
    }

    public Pedido procesarPedido(Pedido pedido) {
        inventarioService.verificarStock(pedido.getProducto());
        double subtotal = inventarioService.getPrecioUnitario() * pedido.getCantidad();
        pedido.setTotal(tributacionService.calcularTotal(subtotal));
        return pedido;
    }
}
