package com.usil.observer;

public class EmailNotifier implements Observer{

    @Override
    public void update(String event, double amount) {
        System.out.println("Email:"+event+" de S/.:"+amount);
    }
    
}
