package com.usil;

import com.usil.model.Alumno;
import com.usil.model.Curso;
import com.usil.model.Docente;
import com.usil.model.Persona;
import java.util.ArrayList;
import java.util.List;

public class S02Actividad02 {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        Alumno hamp = new Alumno("20262345", "Henry Antonio Mendoza Puerta", cursos);
        
        hamp.mostrarCursos();
        
        Docente maria = new Docente("40745678", "Maria", "Plasencia Burgos", "Programacion","Ingenieria") ;
        
        for(Curso curso: hamp.getCursos()){
            maria.calificarCurso(curso);
        }
        
    }
}
