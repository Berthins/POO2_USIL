package com.usil.scooter.repository.impl;

import com.usil.scooter.model.Scooter;
import com.usil.scooter.repository.ScooterRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implementa el CRUD y la consulta de ScooterRepository. Los scooters viven en una lista. */
public class ScooterRepositoryImpl implements ScooterRepository {

    private final List<Scooter> scooters = new ArrayList<>();

    @Override
    public Scooter crear(Scooter scooter) {
        scooter.setId(scooters.stream().mapToInt(Scooter::getId).max().orElse(0) + 1);
        scooters.add(scooter);
        return scooter;
    }

    @Override
    public Optional<Scooter> buscarPorId(Integer id) {
        return scooters.stream().filter(s -> s.getId() == id).findFirst();
    }

    @Override
    public boolean existePorId(Integer id) {
        return scooters.stream().anyMatch(s -> s.getId() == id);
    }

    @Override
    public List<Scooter> listar() {
        return List.copyOf(scooters);
    }

    @Override
    public Scooter actualizar(Scooter scooter) {
        scooters.replaceAll(s -> s.getId() == scooter.getId() ? scooter : s);
        return scooter;
    }

    @Override
    public void eliminar(Integer id) {
        scooters.removeIf(s -> s.getId() == id);
    }

    @Override
    public List<Scooter> buscarPorMarca(String marca) {
        return scooters.stream()
                .filter(s -> s.getMarca().toLowerCase().contains(marca.toLowerCase()))
                .toList();
    }
}
