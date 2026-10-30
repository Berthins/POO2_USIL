package com.usil.scooter.repository;

import com.usil.scooter.model.Scooter;
import java.util.List;

/** CRUD general + la consulta propia de Scooter. */
public interface ScooterRepository extends CrudRepository<Scooter, Integer> {

    List<Scooter> buscarPorMarca(String marca);
}
