package com.usil.controlador;

import com.usil.service.EstudianteService;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    public void registrarEstudiante(String codigo, String nombres, String nota1, String nota2, String nota3) {
        service.registrar(codigo, nombres, nota1, nota2, nota3);
    }

    public List<String[]> listarEstudiantes() {
        return service.listar().stream()
            .map(e -> new String[]{
                e.getCodigo(),
                e.getNombres(),
                String.format(Locale.US, "%.2f", service.calcularPromedio(e)),
                service.obtenerCondicion(e)})
            .collect(Collectors.toList());
    }

    public Optional<String> buscarEstudiante(String codigo) {
        return service.buscarPorCodigo(codigo)
            .map(e -> String.format(Locale.US,
                "Código: %s%nNombres: %s%nNotas: %.1f - %.1f - %.1f%nPromedio: %.2f%nCondición: %s",
                e.getCodigo(), e.getNombres(), e.getNota1(), e.getNota2(), e.getNota3(),
                service.calcularPromedio(e), service.obtenerCondicion(e)));
    }

    public String obtenerResumen() {
        return String.format(Locale.US,
            "Promedio general: %.2f%nAprobados: %d%nDesaprobados: %d",
            service.calcularPromedioGeneral(), service.contarAprobados(), service.contarDesaprobados());
    }
}
