package com.usil.scooter.controller;

import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Pago;
import com.usil.scooter.service.AlquilerService;
import com.usil.scooter.service.PagoService;
import java.time.LocalDate;
import java.util.List;

/** Controller de Pago. Solo conoce a los services (PagoService y AlquilerService, de donde carga los alquileres). */
public class PagoController {

    private final PagoService pagoService;
    private final AlquilerService alquilerService;

    public PagoController(PagoService pagoService, AlquilerService alquilerService) {
        this.pagoService = pagoService;
        this.alquilerService = alquilerService;
    }

    public void pagar(int idAlquiler, String tarjeta) {
        pagoService.pagar(idAlquiler, tarjeta);
    }

    public List<Alquiler> alquileresPendientes() {
        return alquilerService.listarPendientes();
    }

    public List<Pago> listar() {
        return pagoService.listar();
    }

    public List<Pago> buscar(int id) {
        return pagoService.buscarPorId(id).stream().toList();
    }

    public List<Pago> filtrar(LocalDate desde, LocalDate hasta) {
        return pagoService.filtrarPorFecha(desde, hasta);
    }
}
