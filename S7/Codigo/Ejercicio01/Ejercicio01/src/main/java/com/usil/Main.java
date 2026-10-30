package com.usil;

import com.usil.facade.SistemaReservas;
import com.usil.modelo.Reserva;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final int PERSONAS_GRUPO = 4;

    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();

        List<Reserva> reservasDePrueba = List.of(
            new Reserva("RES-004", "CUSCO", "Ana Soto", 2, 450.00),
            new Reserva("RES-001", "AREQUIPA", "Luis Vega", 5, 300.00),
            new Reserva("RES-003", "PARACAS", "Rosa León", 0, 200.00),
            new Reserva("RES-002", "CUSCO", "Marta Gil", 4, 450.00),
            new Reserva("RES-005", "PARACAS", "Juan Pérez", 3, 180.00));

        reservasDePrueba.forEach(reserva -> {
            if (!sistema.registrarReserva(reserva)) {
                System.out.println("Reserva " + reserva.getCodigo() + " RECHAZADA: datos no válidos.");
            }
        });

        System.out.println();
        System.out.println("=== RESERVAS REGISTRADAS (ordenadas por código) ===");
        sistema.obtenerReservas().stream()
            .sorted(Comparator.comparing(Reserva::getCodigo))
            .forEach(r -> System.out.printf(java.util.Locale.US,
                "%s | %-10s | %-9s | Total: S/ %.2f | Cupos: %d%n",
                r.getCodigo(), r.getCliente(), r.getDestino(),
                sistema.calcularTotal(r), sistema.consultarCupos(r.getDestino())));

        long cantidad = sistema.obtenerReservas().stream().count();
        double sumaTotales = sistema.obtenerReservas().stream()
            .mapToDouble(sistema::calcularTotal)
            .sum();
        String reservasGrupo = sistema.obtenerReservas().stream()
            .filter(r -> r.getNumeroPersonas() >= PERSONAS_GRUPO)
            .map(Reserva::getCodigo)
            .sorted()
            .collect(Collectors.joining(", "));

        System.out.println();
        System.out.println("Cantidad de reservas registradas: " + cantidad);
        System.out.printf(java.util.Locale.US, "Suma de totales: S/ %.2f%n", sumaTotales);
        System.out.println("Reservas de grupo (4 personas o más): " + reservasGrupo);
    }
}
