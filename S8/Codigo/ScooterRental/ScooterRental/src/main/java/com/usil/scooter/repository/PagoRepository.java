package com.usil.scooter.repository;

import com.usil.scooter.model.Pago;
import java.time.LocalDate;
import java.util.List;

/** CRUD general + la consulta propia de Pago. */
public interface PagoRepository extends CrudRepository<Pago, Integer> {

    /** Pagos realizados entre las dos fechas (incluidas). */
    List<Pago> buscarPorFecha(LocalDate desde, LocalDate hasta);
}
