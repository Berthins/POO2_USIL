package pe.usil.pedido.facade;

public class TributacionService {

    private static final double IGV = 0.18;

    public double calcularTotal(double subtotal) {
        return subtotal + (subtotal * IGV);
    }
}
