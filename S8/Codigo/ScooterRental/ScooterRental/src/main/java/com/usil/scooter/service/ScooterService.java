package com.usil.scooter.service;

import com.usil.scooter.builder.ScooterBuilder;
import com.usil.scooter.model.Scooter;
import com.usil.scooter.repository.AlquilerRepository;
import com.usil.scooter.repository.ScooterRepository;
import java.util.List;
import java.util.Optional;

public class ScooterService {

    private final ScooterRepository repositorio;
    private final AlquilerRepository alquilerRepositorio;

    public ScooterService(ScooterRepository repositorio, AlquilerRepository alquilerRepositorio) {
        this.repositorio = repositorio;
        this.alquilerRepositorio = alquilerRepositorio;
    }

    public void registrar(String marca, String modelo, double tarifaPorMinuto) {
        repositorio.crear(new ScooterBuilder().marca(marca).modelo(modelo).tarifaPorMinuto(tarifaPorMinuto).build());
    }

    public List<Scooter> listar() {
        return repositorio.listar();
    }

    public Optional<Scooter> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public List<Scooter> filtrarPorMarca(String marca) {
        return repositorio.buscarPorMarca(marca);
    }

    public void actualizar(int id, String marca, String modelo, double tarifaPorMinuto) {
        Scooter scooter = repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el scooter " + id + "."));
        Scooter nuevo = new ScooterBuilder().marca(marca).modelo(modelo).tarifaPorMinuto(tarifaPorMinuto).build(); // valida
        scooter.setMarca(nuevo.getMarca());
        scooter.setModelo(nuevo.getModelo());
        scooter.setTarifaPorMinuto(nuevo.getTarifaPorMinuto());
        repositorio.actualizar(scooter);
    }

    /** Un scooter con alquileres no se puede eliminar. */
    public void eliminar(int id) {
        if (!repositorio.existePorId(id)) {
            throw new IllegalArgumentException("No existe el scooter " + id + ".");
        }
        if (alquilerRepositorio.existePorScooterId(id)) {
            throw new IllegalArgumentException("El scooter tiene alquileres. Elimine primero esos alquileres.");
        }
        repositorio.eliminar(id);
    }
}
