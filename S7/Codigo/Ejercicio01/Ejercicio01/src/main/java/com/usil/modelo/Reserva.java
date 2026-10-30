package com.usil.modelo;

public class Reserva {

    private final String codigo;
    private final String destino;
    private final String cliente;
    private final int numeroPersonas;
    private final double precioPorPersona;

    public Reserva(String codigo, String destino, String cliente, int numeroPersonas, double precioPorPersona) {
        this.codigo = codigo;
        this.destino = destino;
        this.cliente = cliente;
        this.numeroPersonas = numeroPersonas;
        this.precioPorPersona = precioPorPersona;
    }

    public String getCodigo() { return codigo; }
    public String getDestino() { return destino; }
    public String getCliente() { return cliente; }
    public int getNumeroPersonas() { return numeroPersonas; }
    public double getPrecioPorPersona() { return precioPorPersona; }
}
