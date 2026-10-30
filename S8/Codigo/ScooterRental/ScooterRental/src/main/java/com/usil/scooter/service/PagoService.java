package com.usil.scooter.service;

import com.usil.scooter.adapter.PasarelaPago;
import com.usil.scooter.builder.PagoBuilder;
import com.usil.scooter.model.Alquiler;
import com.usil.scooter.model.Pago;
import com.usil.scooter.repository.PagoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PagoService {

    private final PagoRepository repositorio;
    private final PasarelaPago pasarelaPago;
    private final AlquilerService alquilerService;

    public PagoService(PagoRepository repositorio, PasarelaPago pasarelaPago, AlquilerService alquilerService) {
        this.repositorio = repositorio;
        this.pasarelaPago = pasarelaPago;
        this.alquilerService = alquilerService;
    }

    /** Pagar: cobra con la pasarela (Adapter), guarda el Pago (PagoBuilder) y marca el alquiler como pagado. */
    public void pagar(int idAlquiler, String tarjeta) {
        Alquiler alquiler = alquilerService.buscarPorId(idAlquiler)
                .orElseThrow(() -> new IllegalArgumentException("No existe el alquiler " + idAlquiler + "."));
        if (alquiler.isPagado()) {
            throw new IllegalArgumentException("Este alquiler ya esta pagado.");
        }
        pasarelaPago.cobrar(alquiler.getMonto(), tarjeta);
        repositorio.crear(new PagoBuilder().alquiler(alquiler).tarjeta(tarjeta).build());
        alquilerService.marcarPagado(idAlquiler);
    }

    public List<Pago> listar() {
        return repositorio.listar();
    }

    public Optional<Pago> buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public List<Pago> filtrarPorFecha(LocalDate desde, LocalDate hasta) {
        if (desde.isAfter(hasta)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        return repositorio.buscarPorFecha(desde, hasta);
    }
}
