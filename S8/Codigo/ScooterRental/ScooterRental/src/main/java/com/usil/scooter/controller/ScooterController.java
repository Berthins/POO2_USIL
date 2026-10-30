package com.usil.scooter.controller;

import com.usil.scooter.model.Scooter;
import com.usil.scooter.service.ScooterService;
import java.util.List;

/** Controller de Scooter. Solo conoce a su service. */
public class ScooterController {

    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    public void registrar(String marca, String modelo, double tarifa) {
        scooterService.registrar(marca, modelo, tarifa);
    }

    public void actualizar(int id, String marca, String modelo, double tarifa) {
        scooterService.actualizar(id, marca, modelo, tarifa);
    }

    public void eliminar(int id) {
        scooterService.eliminar(id);
    }

    public List<Scooter> listar() {
        return scooterService.listar();
    }

    public List<Scooter> buscar(int id) {
        return scooterService.buscarPorId(id).stream().toList();
    }

    public List<Scooter> filtrar(String marca) {
        return scooterService.filtrarPorMarca(marca);
    }
}
