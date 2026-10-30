package com.usil.observer;

//update(): es el unico punto de contacto: el sujeto llama
//a este metodo para avisar el cambio
public interface Observer {
    void update(String event, double amount);
}
