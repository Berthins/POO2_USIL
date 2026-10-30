package pe.usil.pedido;

import pe.usil.pedido.adapter.FacturaAdapter;
import pe.usil.pedido.adapter.LegacyBillingSystem;
import pe.usil.pedido.controller.PedidoController;
import pe.usil.pedido.facade.InventarioService;
import pe.usil.pedido.facade.PedidoFacade;
import pe.usil.pedido.facade.TributacionService;
import pe.usil.pedido.view.PedidoView;

import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        PedidoFacade pedidoFacade = new PedidoFacade(new InventarioService(), new TributacionService());
        FacturaAdapter facturaAdapter = new FacturaAdapter(new LegacyBillingSystem());
        PedidoController controller = new PedidoController(pedidoFacade, facturaAdapter);

        SwingUtilities.invokeLater(() -> {
            PedidoView view = new PedidoView();
            view.setController(controller);
            view.setLocationRelativeTo(null);
            view.setVisible(true);
        });
    }
}
