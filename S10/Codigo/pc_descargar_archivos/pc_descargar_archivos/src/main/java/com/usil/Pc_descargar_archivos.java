package com.usil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pc_descargar_archivos { 
    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();//hora de inicio
    
        /*Descarga d1 = new Descarga("video.mp4", 4);
        Descarga d2 = new Descarga("foto.jpg", 1);
        Descarga d3 = new Descarga("musica.mp3", 2);
        
        d1.start(); //Hilo 01
        d2.start(); //Hilo 02
        d3.start(); //Hilo 03
        
        d1.join();
        d2.join();
        d3.join();
        
        
        long total = (System.currentTimeMillis()- inicio)/1000;
        System.out.println("Tiempo total:"+total+" segundos");*/
        
        //pool de hilos (3 impresoras)
        ExecutorService pool = Executors.newFixedThreadPool(3);
        
        //enviar 6 documentos al pool de impresoras
        pool.submit(new Documento("Informe.pdf", 2));
        pool.submit(new Documento("Tesis.pdf", 3));
        pool.submit(new Documento("Boleta.pdf", 1));
        pool.submit(new Documento("Contrato.pdf", 2));
        pool.submit(new Documento("Foto.png", 1));
        pool.submit(new Documento("Resumen.txt", 2));
        
        pool.shutdown(); //no se aceptan mas documentos
        pool.awaitTermination(1, TimeUnit.MINUTES); //Espera a que terminen todos

        long total = (System.currentTimeMillis()- inicio)/1000;
        System.out.println("Tiempo total:"+total+" segundos");
        
    
    }
}
