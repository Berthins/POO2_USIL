package com.usil.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.usil.modelo.Estudiante;

public class EstudianteService {

    private static final double NOTA_MINIMA = 0;
    private static final double NOTA_MAXIMA = 20;
    private static final double NOTA_APROBATORIA = 11;

    private final List<Estudiante> estudiantes = new ArrayList<>();

    public void registrar(String codigo, String nombres, String nota1, String nota2, String nota3) {
        if (esVacio(codigo) || esVacio(nombres) || esVacio(nota1) || esVacio(nota2) || esVacio(nota3)) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        String codigoLimpio = codigo.trim();
        if (!codigoLimpio.matches("\\d{6}")) {
            throw new IllegalArgumentException("El código debe tener 6 dígitos.");
        }
        if (existeCodigo(codigoLimpio)) {
            throw new IllegalArgumentException("El código " + codigoLimpio + " ya está registrado.");
        }
        double n1 = convertirNota(nota1);
        double n2 = convertirNota(nota2);
        double n3 = convertirNota(nota3);
        estudiantes.add(new Estudiante(codigoLimpio, nombres.trim(), n1, n2, n3));
    }

    public List<Estudiante> listar() {
        return Collections.unmodifiableList(estudiantes);
    }

    public Optional<Estudiante> buscarPorCodigo(String codigo) {
        return estudiantes.stream()
            .filter(e -> e.getCodigo().equals(codigo.trim()))
            .findFirst();
    }

    public double calcularPromedio(Estudiante estudiante) {
        return (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3()) / 3;
    }

    public String obtenerCondicion(Estudiante estudiante) {
        return calcularPromedio(estudiante) >= NOTA_APROBATORIA ? "Aprobado" : "Desaprobado";
    }

    public double calcularPromedioGeneral() {
        return estudiantes.stream()
            .mapToDouble(this::calcularPromedio)
            .average()
            .orElse(0);
    }

    public long contarAprobados() {
        return estudiantes.stream()
            .filter(e -> calcularPromedio(e) >= NOTA_APROBATORIA)
            .count();
    }

    public long contarDesaprobados() {
        return estudiantes.size() - contarAprobados();
    }

    private boolean existeCodigo(String codigo) {
        return estudiantes.stream().anyMatch(e -> e.getCodigo().equals(codigo));
    }

    private boolean esVacio(String texto) {
        return texto == null || texto.isBlank();
    }

    private double convertirNota(String texto) {
        double nota;
        try {
            nota = Double.parseDouble(texto.trim());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Las notas deben ser numéricas.");
        }
        if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
            throw new IllegalArgumentException("Cada nota debe estar entre 0 y 20.");
        }
        return nota;
    }
}
