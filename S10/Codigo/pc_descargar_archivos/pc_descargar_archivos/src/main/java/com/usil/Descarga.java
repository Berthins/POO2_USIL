package com.usil;

import java.time.Duration;

public class Descarga extends Thread{ //Descarga es un HILO
    
    private String archivo;
    private int segundos;
    
    public Descarga(String archivo, int segundos){
        this.archivo = archivo;
        this.segundos = segundos;
    }
    
    
    @Override
   public void run(){ //lo que hace el hilo al inicia
       System.out.println("Descargando "+archivo+"...");
       try {
           Thread.sleep(segundos * 1000L);//simula la demora
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }
       System.out.println("Listo "+archivo);
   }
}
