package com.usil.controller;

import com.usil.model.TipoVehiculo;
import com.usil.model.Vehiculo;
import com.usil.service.AlquilerService;
import java.util.List;

public class AlquilerController {

    private final AlquilerService alquilerService = AlquilerService.getInstance();

    //Peticion (REQUEST) obtener los tipos de vehiculo disponibles (Factory)
    public TipoVehiculo[] obtenerTiposVehiculo() {
        return TipoVehiculo.values();
    }

    //Peticion (REQUEST) registrar un vehiculo
    public Vehiculo registrarVehiculo(String placa, String marca, String modelo, int anio, TipoVehiculo tipo) {
        return alquilerService.registrarVehiculo(placa, marca, modelo, anio, tipo);
    }

    //Peticion (REQUEST) listar los vehiculos registrados
    public List<Vehiculo> listarVehiculos() {
        return alquilerService.listarVehiculos();
    }

    //Peticion (REQUEST) buscar vehiculos por placa o tipo
    public List<Vehiculo> buscarPorPlacaOTipo(String criterio) {
        return alquilerService.buscarPorPlacaOTipo(criterio);
    }

}
