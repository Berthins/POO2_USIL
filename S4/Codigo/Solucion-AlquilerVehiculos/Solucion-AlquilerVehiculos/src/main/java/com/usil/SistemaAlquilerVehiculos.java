package com.usil;

import com.usil.view.AlquilerView;

public class SistemaAlquilerVehiculos {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(
                () -> new AlquilerView().setVisible(true)
        );
    }

}
