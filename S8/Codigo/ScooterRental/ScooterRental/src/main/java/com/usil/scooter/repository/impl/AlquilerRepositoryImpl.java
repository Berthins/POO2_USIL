package com.usil.scooter.repository.impl;

import com.usil.scooter.model.Alquiler;
import com.usil.scooter.repository.AlquilerRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implementa el CRUD y las consultas de AlquilerRepository. Los alquileres viven en una lista. */
public class AlquilerRepositoryImpl implements AlquilerRepository {

    private final List<Alquiler> alquileres = new ArrayList<>();

    @Override
    public Alquiler crear(Alquiler alquiler) {
        alquiler.setId(alquileres.stream().mapToInt(Alquiler::getId).max().orElse(0) + 1);
        alquileres.add(alquiler);
        return alquiler;
    }

    @Override
    public Optional<Alquiler> buscarPorId(Integer id) {
        return alquileres.stream().filter(a -> a.getId() == id).findFirst();
    }

    @Override
    public boolean existePorId(Integer id) {
        return alquileres.stream().anyMatch(a -> a.getId() == id);
    }

    @Override
    public List<Alquiler> listar() {
        return List.copyOf(alquileres);
    }

    @Override
    public Alquiler actualizar(Alquiler alquiler) {
        alquileres.replaceAll(a -> a.getId() == alquiler.getId() ? alquiler : a);
        return alquiler;
    }

    @Override
    public void eliminar(Integer id) {
        alquileres.removeIf(a -> a.getId() == id);
    }

    @Override
    public List<Alquiler> buscarPorFecha(LocalDate desde, LocalDate hasta) {
        return alquileres.stream()
                .filter(a -> !a.getInicio().toLocalDate().isBefore(desde))
                .filter(a -> !a.getInicio().toLocalDate().isAfter(hasta))
                .toList();
    }

    @Override
    public boolean existePorScooterId(int idScooter) {
        return alquileres.stream().anyMatch(a -> a.getScooter().getId() == idScooter);
    }
}
