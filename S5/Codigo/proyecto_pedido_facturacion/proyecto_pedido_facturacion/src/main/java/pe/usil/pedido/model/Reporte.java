package pe.usil.pedido.model;

import java.util.List;

public class Reporte {

    private final boolean exitoso;
    private final Pedido pedido;
    private final List<String> bitacora;
    private final String mensajeError;

    public Reporte(boolean exitoso, Pedido pedido, List<String> bitacora, String mensajeError) {
        this.exitoso = exitoso;
        this.pedido = pedido;
        this.bitacora = bitacora;
        this.mensajeError = mensajeError;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<String> getBitacora() {
        return bitacora;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
