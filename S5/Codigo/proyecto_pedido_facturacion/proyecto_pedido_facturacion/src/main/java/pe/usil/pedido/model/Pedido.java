package pe.usil.pedido.model;

public class Pedido {

    private final Cliente cliente;
    private final String producto;
    private final int cantidad;
    private double total;

    public Pedido(Cliente cliente, String producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
