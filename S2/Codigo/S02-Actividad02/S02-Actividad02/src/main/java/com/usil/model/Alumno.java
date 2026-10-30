package com.usil.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{
    private String codigoAlumno;
    private String nombreAlumno;
    
    public List<Curso> cursos;

    public Alumno(String codigoAlumno, String nombreAlumno, List<Curso> cursos) {
        this.codigoAlumno = codigoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.cursos = cursos;
        this.leerCursosAlumno("alumno.txt");
    }

    public Alumno(String dni, String nombre, String apellido,String codigoAlumno, String nombreAlumno, List<Curso> cursos) {
        super(dni, nombre, apellido);
        this.codigoAlumno = codigoAlumno;
        this.nombreAlumno = nombreAlumno;
        this.cursos = cursos;
        this.leerCursosAlumno("alumno.txt");
    }
    
    
    private void leerCursosAlumno(String archivo){
        if(cursos == null){
            cursos = new ArrayList<>();
        }        
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea= br.readLine())!= null){
                if(!linea.isBlank()){
                    cursos.add(new Curso(linea.trim()));
                }
            }
        }catch(IOException e){
            System.out.println("No se pudo leer el archivo de cursos "+
                    e.getMessage());
        }            
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void mostrarCursos(){
        System.out.println("Cursos matriculados de "+ nombreAlumno);         
        for (Curso curso : cursos) {
            System.out.println("-"+ curso.getNombreCurso());
        }
    }
}
