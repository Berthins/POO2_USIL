package pe.usil.pedido.facade;

import java.util.List;

public class InventarioService {

    private static final double PRECIO_UNITARIO = 20.00;
    private static final List<String> PRODUCTOS_DISPONIBLES = List.of("Laptop", "Mouse", "Teclado");

    public double getPrecioUnitario() {
        return PRECIO_UNITARIO;
    }

    public void verificarStock(String producto) {
        boolean disponible = PRODUCTOS_DISPONIBLES.stream().anyMatch(p -> p.equalsIgnoreCase(producto));
        if (!disponible) {
            throw new IllegalStateException("Stock insuficiente para el producto " + producto);
        }
    }
}
