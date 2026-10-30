package com.usil.scooter.model;

import java.time.LocalDateTime;

/** Registro de un pago aprobado de un alquiler. */
public class Pago {

    private int id;
    private Alquiler alquiler;
    private double monto;
    private String tarjeta;          // enmascarada: **** 1234
    private LocalDateTime fecha;

    public Pago(Alquiler alquiler, double monto, String tarjeta, LocalDateTime fecha) {
        this.alquiler = alquiler;
        this.monto = monto;
        this.tarjeta = tarjeta;
        this.fecha = fecha;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Alquiler getAlquiler() { return alquiler; }

    public void setAlquiler(Alquiler alquiler) { this.alquiler = alquiler; }

    public double getMonto() { return monto; }

    public void setMonto(double monto) { this.monto = monto; }

    public String getTarjeta() { return tarjeta; }

    public void setTarjeta(String tarjeta) { this.tarjeta = tarjeta; }

    public LocalDateTime getFecha() { return fecha; }

    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
