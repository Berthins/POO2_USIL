package com.usil.factory;

import com.usil.model.Sedan;
import com.usil.model.Suv;
import com.usil.model.TipoVehiculo;
import com.usil.model.Vehiculo;

/**
 * Patron Factory: centraliza la creacion de las subclases de Vehiculo
 * (herencia) segun el tipo elegido, de forma que el resto de la
 * aplicacion no use "new" directamente sobre Sedan ni Suv.
 */
public class VehiculoFactory {

    private VehiculoFactory() {
    }

    public static Vehiculo crearVehiculo(TipoVehiculo tipo, String placa, String marca, String modelo, int anio) {
        if (tipo == null) {
            throw new IllegalArgumentException("Debe seleccionar un tipo de vehiculo");
        }
        switch (tipo) {
            case SEDAN:
                return new Sedan(placa, marca, modelo, anio);
            case SUV:
                return new Suv(placa, marca, modelo, anio);
            default:
                throw new IllegalArgumentException("Tipo de vehiculo no soportado: " + tipo);
        }
    }

}
