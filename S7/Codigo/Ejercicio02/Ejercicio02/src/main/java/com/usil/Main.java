package com.usil;

import com.usil.controlador.EstudianteController;
import com.usil.service.EstudianteService;
import com.usil.vista.VentanaEstudiantes;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstudianteService service = new EstudianteService();
            EstudianteController controlador = new EstudianteController(service);
            new VentanaEstudiantes(controlador).setVisible(true);
        });
    }
}
