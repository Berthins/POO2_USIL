package com.usil.service;

import com.usil.builder.VehiculoBuilder;
import com.usil.model.TipoVehiculo;
import com.usil.model.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlquilerService {

    private static final AlquilerService INSTANCIA = new AlquilerService();

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    private AlquilerService() {
    }

    public static AlquilerService getInstance() {
        return INSTANCIA;
    }

    public Vehiculo registrarVehiculo(String placa, String marca, String modelo, int anio, TipoVehiculo tipo) {
        // Builder: arma el vehiculo paso a paso y, en build(), usa la Factory
        Vehiculo vehiculo = new VehiculoBuilder()
                .conPlaca(placa)
                .conMarca(marca)
                .conModelo(modelo)
                .conAnio(anio)
                .conTipo(tipo)
                .build();

        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculos;
    }

    public List<Vehiculo> buscarPorPlacaOTipo(String criterio) {
        String criterioNormalizado = criterio.toLowerCase();

        // Version tradicional (con for), comentada como referencia:
        // List<Vehiculo> resultado = new ArrayList<>();
        // for (Vehiculo v : vehiculos) {
        //     if (v.getPlaca().toLowerCase().contains(criterioNormalizado)
        //             || v.getTipo().toLowerCase().contains(criterioNormalizado)) {
        //         resultado.add(v);
        //     }
        // }
        // return resultado;

        // Version con programacion funcional (streams):
        return vehiculos.stream()
                .filter(v -> v.getPlaca().toLowerCase().contains(criterioNormalizado)
                        || v.getTipo().toLowerCase().contains(criterioNormalizado))
                .collect(Collectors.toList());
    }

}
