package com.usil.model;

import java.util.Random;

public class Docente extends Persona{
    private String cursoDocente;
    private String facultadDocente;

    public Docente( String dni, String nombre, String apellido,
            String cursoDocente, String facultadDocente) {
        super(dni, nombre, apellido);
        this.cursoDocente = cursoDocente;
        this.facultadDocente = facultadDocente;
    }

    public int calificarCurso(Curso curso){
        int nota;
        Random random = new Random();
        nota = random.nextInt(21);//entero entre 0 y 20
        System.out.println("El docente "+this.getNombre()
                + " califico el curso "+ curso.getNombreCurso()
                + " con nota:"+ nota);
        return nota;
    }
    
    public String getCursoDocente() {
        return cursoDocente;
    }

    public void setCursoDocente(String cursoDocente) {
        this.cursoDocente = cursoDocente;
    }

    public String getFacultadDocente() {
        return facultadDocente;
    }

    public void setFacultadDocente(String facultadDocente) {
        this.facultadDocente = facultadDocente;
    }
    
    
    
    
    
}
