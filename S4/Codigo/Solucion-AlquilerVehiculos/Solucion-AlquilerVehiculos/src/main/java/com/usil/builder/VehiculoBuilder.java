package com.usil.builder;

import com.usil.factory.VehiculoFactory;
import com.usil.model.TipoVehiculo;
import com.usil.model.Vehiculo;

/**
 * Patron Builder: arma el vehiculo paso a paso (placa, marca, modelo,
 * anio y tipo) y, en build(), usa VehiculoFactory para crear la
 * subclase final segun el tipo indicado.
 */
public class VehiculoBuilder {

    private String placa;
    private String marca;
    private String modelo;
    private int anio;
    private TipoVehiculo tipo;

    public VehiculoBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoBuilder conModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VehiculoBuilder conAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public VehiculoBuilder conTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
        return this;
    }

    public Vehiculo build() {
        if (placa == null || placa.isBlank()) {
            throw new IllegalStateException("Debe indicar la placa del vehiculo");
        }
        return VehiculoFactory.crearVehiculo(tipo, placa, marca, modelo, anio);
    }

}
