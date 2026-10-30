package com.usil.controller;

import com.usil.model.Genero;
import com.usil.model.Libro;
import com.usil.service.LibroService;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class LibroController {
    private LibroService servicio;
    
    public LibroController(LibroService servicio){
        this.servicio = servicio;
    }
    
    public String registrarLibro(String codigo, String titulo, String autor,
            Genero genero, String precioTexto, String stockTexto){
        
        try{
            double precio = Double.parseDouble(precioTexto.trim());
            int stock = Integer.parseInt(stockTexto.trim());
            servicio.registrar(new Libro(codigo.trim(), titulo.trim(),
                    autor.trim(), genero, precio, stock));
            return "Libro registrado correctamente";  
        }catch(NumberFormatException e){
         return "El precio y el stock debe ser numericos"   ;
        }catch(IllegalArgumentException e){
         return e.getMessage()   ;
        }                
    }
    
    public List<Libro> listarLibros(){
        return servicio.listarOrdenadosPorTitulo();
    }
    
    public List<Libro> buscarPorGenero(Genero genero){
        return servicio.buscarPorGenero(genero);
    }
    
    public String reportePorGenero(){
        String linea = servicio.generarReportePorGenero().stream()
                .map(r-> String.format("%s: %d libro(s) | S/. %.2f",
                    r.genero(), r.cantidad(), r.valorInventario()))
                .collect(Collectors.joining("\n"));
        return "Reporte por genero:\n" + linea;
    }
    
    public String reporteEstadisticas(){
        DoubleSummaryStatistics estadisticas = 
                servicio.calcularEstadisticasDePrecio();
        
        String masCaro = servicio.buscarMasCaro()
                .map(l->l.getTitulo()+ "("+ l.getAutor()+")")
                .orElse("Sin libros");
        
        return String.format("Estadisticas de precios: %nMinimo: S/ %.2f%nMaximo: S/ %.2f%nPromedio: S/%.2fnLibro mas caro: %s",
                  estadisticas.getMin(), estadisticas.getMax(), 
                  estadisticas.getAverage(), masCaro
                );
    }
    
}
