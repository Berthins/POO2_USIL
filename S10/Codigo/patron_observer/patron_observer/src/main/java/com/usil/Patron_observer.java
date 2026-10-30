package com.usil;

import com.usil.observer.EmailNotifier;
import com.usil.observer.Observer;
import com.usil.observer.SmsNotifier;
import com.usil.observer.Wallet;


public class Patron_observer {

    public static void main(String[] args) {
        //Subject (Publisher) -> Canal Youtube
        Wallet wallet = new Wallet(900);
        
        //Obserser (Subscribirse | Desuscribirse )
        Observer email = new EmailNotifier();
        Observer sms = new SmsNotifier();
        
        //Subscribirse -> observer email se suscribe a wallet
        wallet.attach(email);       
        //Subscribirse -> observer sms se suscribe a wallet
        wallet.attach(sms);
        wallet.pay(120);
        
        
         //Desubscribirse -> observer sms se suscribe a wallet
        wallet.detach(sms);       
        wallet.pay(45.5);
        
        
        
    }
}
