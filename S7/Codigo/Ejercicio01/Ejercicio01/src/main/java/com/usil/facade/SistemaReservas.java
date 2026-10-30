package com.usil.facade;

import com.usil.adapter.AdaptadorCupos;
import com.usil.adapter.ProveedorCupos;
import com.usil.adapter.SistemaCuposExterno;
import com.usil.modelo.Reserva;
import com.usil.subsistema.CalculadoraPrecio;
import com.usil.subsistema.RegistroReservas;
import com.usil.subsistema.ValidadorReserva;
import java.util.List;

public class SistemaReservas {

    private final ValidadorReserva validador = new ValidadorReserva();
    private final CalculadoraPrecio calculadora = new CalculadoraPrecio();
    private final RegistroReservas registro = new RegistroReservas();
    private final ProveedorCupos proveedorCupos = new AdaptadorCupos(new SistemaCuposExterno());

    public boolean registrarReserva(Reserva reserva) {
        if (!validarReserva(reserva)) {
            return false;
        }
        registro.agregar(reserva);
        return true;
    }

    public boolean validarReserva(Reserva reserva) {
        return validador.esValida(reserva);
    }

    public double calcularTotal(Reserva reserva) {
        return calculadora.calcularTotal(reserva);
    }

    public int consultarCupos(String destino) {
        return proveedorCupos.consultarCupos(destino);
    }

    public List<Reserva> obtenerReservas() {
        return registro.obtenerTodas();
    }
}
