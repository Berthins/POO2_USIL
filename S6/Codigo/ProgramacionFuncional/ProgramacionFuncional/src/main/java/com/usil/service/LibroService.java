package com.usil.service;

import com.usil.model.Genero;
import com.usil.model.Libro;
import com.usil.model.ReporteGenero;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibroService {
    
    //public Libro(String codigo, String titulo, String autor, Genero genero, double precio, int stock) {
    private final List<Libro> libros = new ArrayList<>(
            List.of(
                    new Libro("L001","Dune", "Herbert",Genero.CIENCIA_FICCION, 45.0,3),
                    new Libro("L002","It", "King",Genero.TERROR, 38.5,3)
    ));
    
    
    public void registrar(Libro libro){
        if(libro.getCodigo().isBlank() || libro.getTitulo().isBlank() 
                || libro.getAutor().isBlank()){
            throw new IllegalArgumentException("El codigo, titulo y autor son obligatorios");
        }
        
        if(libro.getPrecio()<=0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        
        if(libro.getStock()<0){
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        
        //Programacion funcional
        boolean codigoExiste  = libros.stream()
                .anyMatch(l->l.getCodigo().equalsIgnoreCase(libro.getCodigo()));
        
        if(codigoExiste){
            throw new IllegalArgumentException("Ya existe un libro con el codigo "+libro.getCodigo());
        }
        
        libros.add(libro);        
    }
    
    public List<Libro> listarOrdenadosPorTitulo(){
        return libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .toList();
    }
    
    public List<Libro> buscarPorGenero(Genero genero){
        return libros.stream()
                .filter(l->l.getGenero() == genero)
                .sorted(Comparator.comparing(Libro::getTitulo))
                .toList();
    }
    
    public List<ReporteGenero> generarReportePorGenero(){
        return libros.stream()
                .collect(Collectors.groupingBy(Libro::getGenero))
                .entrySet().stream()
                .map (e-> new ReporteGenero(
                        e.getKey(),
                        e.getValue().size(),
                        e.getValue().stream()
                              .mapToDouble(l->l.getPrecio() * l.getStock())
                              .sum()))
                .sorted(Comparator.comparing(ReporteGenero::genero))
                .toList();
    }
    
    
    public DoubleSummaryStatistics calcularEstadisticasDePrecio(){
        return libros.stream()
                .mapToDouble(Libro::getPrecio)
                .summaryStatistics();
    }
    
    public Optional<Libro> buscarMasCaro(){
        return libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));
    }
}
