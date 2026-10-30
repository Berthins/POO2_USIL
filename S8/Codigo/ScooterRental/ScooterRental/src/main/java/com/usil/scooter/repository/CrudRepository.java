package com.usil.scooter.repository;

import java.util.List;
import java.util.Optional;

/** Operaciones generales (CRUD) comunes a todas las entidades. T = entidad, ID = tipo de su identificador. */
public interface CrudRepository<T, ID> {

    T crear(T entidad);

    Optional<T> buscarPorId(ID id);

    boolean existePorId(ID id);

    List<T> listar();

    T actualizar(T entidad);

    void eliminar(ID id);
}
