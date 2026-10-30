package com.usil.scooter.repository.impl;

import com.usil.scooter.model.Pago;
import com.usil.scooter.repository.PagoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Implementa el CRUD de PagoRepository. Los pagos viven en una lista. */
public class PagoRepositoryImpl implements PagoRepository {

    private final List<Pago> pagos = new ArrayList<>();

    @Override
    public Pago crear(Pago pago) {
        pago.setId(pagos.stream().mapToInt(Pago::getId).max().orElse(0) + 1);
        pagos.add(pago);
        return pago;
    }

    @Override
    public Optional<Pago> buscarPorId(Integer id) {
        return pagos.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public boolean existePorId(Integer id) {
        return pagos.stream().anyMatch(p -> p.getId() == id);
    }

    @Override
    public List<Pago> listar() {
        return List.copyOf(pagos);
    }

    @Override
    public Pago actualizar(Pago pago) {
        pagos.replaceAll(p -> p.getId() == pago.getId() ? pago : p);
        return pago;
    }

    @Override
    public void eliminar(Integer id) {
        pagos.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Pago> buscarPorFecha(LocalDate desde, LocalDate hasta) {
        return pagos.stream()
                .filter(p -> !p.getFecha().toLocalDate().isBefore(desde))
                .filter(p -> !p.getFecha().toLocalDate().isAfter(hasta))
                .toList();
    }
}
