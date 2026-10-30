package com.usil.scooter.repository;

import com.usil.scooter.model.Alquiler;
import java.time.LocalDate;
import java.util.List;

/** CRUD general + las consultas propias de Alquiler. */
public interface AlquilerRepository extends CrudRepository<Alquiler, Integer> {

    /** Alquileres que empezaron entre las dos fechas (incluidas). */
    List<Alquiler> buscarPorFecha(LocalDate desde, LocalDate hasta);

    /** True si algun alquiler usa ese scooter. */
    boolean existePorScooterId(int idScooter);
}
