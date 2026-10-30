package com.usil.scooter.service;

import com.usil.scooter.builder.AlquilerBuilder;
import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Scooter;
import com.usil.scooter.repository.AlquilerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AlquilerService {

    private final AlquilerRepository repositorio;

    public AlquilerService(AlquilerRepository repositorio) {
        this.repositorio = repositorio;
    }

    /** El alquiler empieza ahora y termina 'minutos' despues; calcular() obtiene minutos y monto. */
    public void registrar(Scooter scooter, String cliente, long minutos) {
        Alquiler alquiler = new AlquilerBuilder().scooter(scooter).cliente(cliente).minutos(minutos).build();
        alquiler.calcular();
        repositorio.crear(alquiler);
    }

    /** Si cambian los minutos, la fecha de fin, los minutos y el monto se recalculan. */
    public void actualizar(int id, String cliente, long minutos) {
        Alquiler alquiler = repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el alquiler " + id + "."));
        if (alquiler.isPagado()) {
            throw new IllegalArgumentException("Un alquiler pagado no se puede modificar.");
        }
        Alquiler nuevo = new AlquilerBuilder().scooter(alquiler.getScooter()).cliente(cliente).minutos(minutos).build(); // valida
        alquiler.setCliente(nuevo.getCliente());
        alquiler.setFin(alquiler.getInicio().plusMinutes(minutos));
        alquiler.calcular();
        repositorio.actualizar(alquiler);
    }

    /** Lo usa PagoService cuando el cobro fue aprobado. */
    public void marcarPagado(int id) {
        Alquiler alquiler = repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el alquiler " + id + "."));
        alquiler.setPagado(true);
        repositorio.actualizar(alquiler);
    }

    /** Alquileres que todavia no se pagaron. */
    public List<Alquiler> listarPendientes() {
        return repositorio.listar().stream().filter(a -> !a.isPagado()).toList();
    }

    public List<Alquiler> listar() {
        return repositorio.listar();
    }

    public Optional<Alquiler> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public List<Alquiler> filtrarPorFecha(LocalDate desde, LocalDate hasta) {
        if (desde.isAfter(hasta)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        return repositorio.buscarPorFecha(desde, hasta);
    }

    public void eliminar(int id) {
        if (!repositorio.existePorId(id)) {
            throw new IllegalArgumentException("No existe el alquiler " + id + ".");
        }
        repositorio.eliminar(id);
    }
}
