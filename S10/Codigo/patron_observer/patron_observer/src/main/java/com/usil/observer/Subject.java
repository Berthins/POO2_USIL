package com.usil.observer;

//Subject: Define como subcribirse, desuscribirse y avisar
//sin depender de clases concretas
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String event, double amount);
}
