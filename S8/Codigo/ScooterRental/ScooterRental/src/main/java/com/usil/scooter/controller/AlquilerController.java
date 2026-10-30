package com.usil.scooter.controller;

import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Scooter;
import com.usil.scooter.service.AlquilerService;
import com.usil.scooter.service.ScooterService;
import java.time.LocalDate;
import java.util.List;

/** Controller de Alquiler. Solo conoce a los services. */
public class AlquilerController {

    private final AlquilerService alquilerService;
    private final ScooterService scooterService;

    public AlquilerController(AlquilerService alquilerService, ScooterService scooterService) {
        this.alquilerService = alquilerService;
        this.scooterService = scooterService;
    }

    public void registrar(Scooter scooter, String cliente, long minutos) {
        alquilerService.registrar(scooter, cliente, minutos);
    }

    public void actualizar(int id, String cliente, long minutos) {
        alquilerService.actualizar(id, cliente, minutos);
    }

    public void eliminar(int id) {
        alquilerService.eliminar(id);
    }

    public List<Alquiler> listar() {
        return alquilerService.listar();
    }

    public List<Alquiler> buscar(int id) {
        return alquilerService.buscarPorId(id).stream().toList();
    }

    public List<Alquiler> filtrar(LocalDate desde, LocalDate hasta) {
        return alquilerService.filtrarPorFecha(desde, hasta);
    }

    public List<Scooter> listarScooters() {
        return scooterService.listar();
    }
}
