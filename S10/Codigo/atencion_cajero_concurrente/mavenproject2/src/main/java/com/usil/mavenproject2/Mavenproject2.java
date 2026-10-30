package com.usil.mavenproject2;

/**
 *
 * @author Usuario
 */
public class Mavenproject2 {
    static int totalClientes = 0;
    
    public static void main(String[] args) throws InterruptedException {
        int[] tiemposCajero1 = {2, 3, 1};
        int[] tiemposCajero2 = {4, 2, 3};
        int[] tiemposCajero3 = {1, 1, 2};

        Thread cajero1 = new Thread(()->{
            System.out.println("Cajero 1 comienza a atender...");
            atenderClientes("Cajero 1", tiemposCajero1);
           }
        );
        
        Thread cajero2 = new Thread(()->{
            System.out.println("\nCajero 2 comienza a atender...");
            atenderClientes("Cajero 2", tiemposCajero2);
           }
        );
        
        
        Thread cajero3 = new Thread(()->{
            System.out.println("\nCajero 3 comienza a atender...");
            atenderClientes("Cajero 3", tiemposCajero3);
           }
        );
        
        
        cajero1.start();
        cajero2.start();
        cajero3.start();
        
        cajero1.join();
        cajero2.join();
        cajero3.join();
        
        System.out.println("\nTodos los cajeros han terminado.");
        System.out.println("\nTotal de clientes atendidos:"+ totalClientes);
    }

    
    public static synchronized void contarCliente(){
        totalClientes++;
    }
    
    public static void atenderClientes(String nombre, int[] tiempos) {
        for (int i = 0; i < tiempos.length; i++) {
            try {
                Thread.sleep(tiempos[i] * 1000); // Simula el tiempo de atención
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contarCliente();
            System.out.println(nombre + " atendió al cliente " + (i + 1) +
                               " en " + tiempos[i] + " segundos.");
        }
        System.out.println(nombre + " terminó su turno.");
    }
}
