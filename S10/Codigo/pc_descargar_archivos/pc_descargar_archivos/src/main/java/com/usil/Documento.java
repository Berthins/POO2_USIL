package com.usil;


public class Documento implements Runnable{
    private String nombre;
    private int segundos;

    public Documento(String nombre, int segundos) {
        this.nombre = nombre;
        this.segundos = segundos;
    }
   
    @Override
    public void run() {
        String impresora = Thread.currentThread().getName();
        System.out.println(impresora + "imprime "+ nombre);
        
        try {
           Thread.sleep(segundos * 1000L);//simula la demora
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }        
        
         System.out.println(impresora + "terminoo "+ nombre);
        
    }
    
}
