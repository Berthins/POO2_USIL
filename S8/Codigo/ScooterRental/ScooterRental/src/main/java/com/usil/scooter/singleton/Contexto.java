package com.usil.scooter.singleton;

import com.usil.scooter.adapter.PasarelaPago;
import com.usil.scooter.adapter.PasarelaPagoAdapter;
import com.usil.scooter.controller.AlquilerController;
import com.usil.scooter.controller.PagoController;
import com.usil.scooter.controller.ScooterController;
import com.usil.scooter.repository.AlquilerRepository;
import com.usil.scooter.repository.PagoRepository;
import com.usil.scooter.repository.ScooterRepository;
import com.usil.scooter.repository.impl.AlquilerRepositoryImpl;
import com.usil.scooter.repository.impl.PagoRepositoryImpl;
import com.usil.scooter.repository.impl.ScooterRepositoryImpl;
import com.usil.scooter.service.AlquilerService;
import com.usil.scooter.service.PagoService;
import com.usil.scooter.service.ScooterService;

/**
 * SINGLETON: una sola instancia que arma el sistema (simula el contexto de Spring).
 * Crea cada objeto una sola vez y las vistas comparten esos mismos objetos.
 */
public class Contexto {

    private static final Contexto INSTANCIA = new Contexto();

    public static Contexto getInstancia() {
        return INSTANCIA;
    }

    private final ScooterRepository scooterRepository = new ScooterRepositoryImpl();
    private final AlquilerRepository alquilerRepository = new AlquilerRepositoryImpl();
    private final PagoRepository pagoRepository = new PagoRepositoryImpl();
    private final PasarelaPago pasarelaPago = new PasarelaPagoAdapter();

    private final ScooterService scooterService = new ScooterService(scooterRepository, alquilerRepository);
    private final AlquilerService alquilerService = new AlquilerService(alquilerRepository);
    private final PagoService pagoService = new PagoService(pagoRepository, pasarelaPago, alquilerService);

    private final ScooterController scooterController = new ScooterController(scooterService);
    private final AlquilerController alquilerController = new AlquilerController(alquilerService, scooterService);
    private final PagoController pagoController = new PagoController(pagoService, alquilerService);

    private Contexto() {
    }

    public ScooterController scooterController() {
        return scooterController;
    }

    public AlquilerController alquilerController() {
        return alquilerController;
    }

    public PagoController pagoController() {
        return pagoController;
    }
}
