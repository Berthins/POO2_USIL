package com.usil.observer;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements Subject {
    
    private List<Observer> observers= new ArrayList<Observer>();
    private double balance;
    
    public Wallet(double balance){
        this.balance = balance;
    }
    

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event, double amount) {
        for (Observer observer : observers) {
            observer.update(event, amount);
        }
    }
    
    public void pay(double amount){
        balance -= amount;
        notifyObservers("PAGO", amount);
    }
    
}
