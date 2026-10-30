package com.usil.observer;


public class SmsNotifier implements Observer{

    @Override
    public void update(String event, double amount) {
        System.out.println("SMS:"+event+" de S/.:"+amount);
    }
    
}
