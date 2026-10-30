package com.usil.adapter;

public class AdaptadorCupos implements ProveedorCupos {

    private final SistemaCuposExterno sistemaExterno;

    public AdaptadorCupos(SistemaCuposExterno sistemaExterno) {
        this.sistemaExterno = sistemaExterno;
    }

    @Override
    public int consultarCupos(String destino) {
        String texto = sistemaExterno.consultar(destino);
        if (texto == null) {
            return 0;
        }
        String[] partes = texto.split(":");
        return Integer.parseInt(partes[1]);
    }
}
