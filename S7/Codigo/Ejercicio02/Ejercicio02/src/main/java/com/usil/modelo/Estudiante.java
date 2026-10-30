package com.usil.modelo;

public class Estudiante {

    private final String codigo;
    private final String nombres;
    private final double nota1;
    private final double nota2;
    private final double nota3;

    public Estudiante(String codigo, String nombres, double nota1, double nota2, double nota3) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public double getNota1() { return nota1; }
    public double getNota2() { return nota2; }
    public double getNota3() { return nota3; }
}
