package com.usil;

import com.usil.view.MenuView;
import javax.swing.SwingUtilities;

public class EjercicioMVC {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            MenuView menuView = new MenuView();
            menuView.setVisible(true);
        });
    }
}
