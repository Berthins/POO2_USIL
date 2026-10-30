package com.usil.scooter.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Alquiler {

    private int id;
    private Scooter scooter;
    private String cliente;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private long minutos;       // se calcula con calcular()
    private double monto;       // se calcula con calcular()
    private boolean pagado;

    public Alquiler(Scooter scooter, String cliente, LocalDateTime inicio, LocalDateTime fin) {
        this.scooter = scooter;
        this.cliente = cliente;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Scooter getScooter() { return scooter; }

    public void setScooter(Scooter scooter) { this.scooter = scooter; }

    public String getCliente() { return cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    public LocalDateTime getInicio() { return inicio; }

    public void setInicio(LocalDateTime inicio) { this.inicio = inicio; }

    public LocalDateTime getFin() { return fin; }

    public void setFin(LocalDateTime fin) { this.fin = fin; }

    public long getMinutos() { return minutos; }

    public double getMonto() { return monto; }

    public boolean isPagado() { return pagado; }

    public void setPagado(boolean pagado) { this.pagado = pagado; }

    /** CALCULOS: minutos = Duration entre inicio y fin; monto = minutos x tarifa por minuto del scooter. */
    public void calcular() {
        minutos = Duration.between(inicio, fin).toMinutes();
        monto = minutos * scooter.getTarifaPorMinuto();
    }

    @Override
    public String toString() {
        return "Alquiler " + id + " - " + cliente + " - " + String.format("%.2f", monto);
    }
}
