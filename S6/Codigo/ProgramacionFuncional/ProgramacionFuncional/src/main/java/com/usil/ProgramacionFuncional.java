/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.usil;

import com.usil.controller.LibroController;
import com.usil.service.LibroService;
import com.usil.view.LibroView;
import javax.swing.SwingUtilities;


public class ProgramacionFuncional {

    public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> {
            LibroService servicio = new LibroService();
            LibroController controlador = new LibroController(servicio);
            LibroView vista = new LibroView(controlador);
            vista.setVisible(true);
        });
    }
}
