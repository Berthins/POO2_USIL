package com.usil;

import builder.Empleado;
import com.usil.view.MenuView;
import factory.Cuadrado;
import factory.Figura;
import factory.FiguraFactory;
import factory.TipoFigura;
import javax.swing.SwingUtilities;

public class EjercicioMVC {

    public static void main(String[] args) {

        /*SwingUtilities.invokeLater(()->{
            MenuView menuView = new MenuView();
            menuView.setVisible(true);
        });*/
        
        /*Figura f1 = FiguraFactory.crearFigura(TipoFigura.CIRCULO);
        Figura f2 = FiguraFactory.crearFigura(TipoFigura.CUADRADO);
        Figura f3 = FiguraFactory.crearFigura(TipoFigura.TRIANGULO);
        
        f1.dibujar();
        f2.dibujar();
        f3.dibujar();*/
        
        Empleado e1 = new Empleado.EmpleadoBuilder("Henry", "Docente")
                .build();
        
        System.out.println(e1.getResumen());
        
        Empleado e2 = new Empleado.EmpleadoBuilder("Juan", "Docente")
                .conArea("Software")
                .build();

        System.out.println(e2.getResumen());
        
        Empleado e3 = new Empleado.EmpleadoBuilder("Juan", "Docente")
                .conArea("Software")
                .conSueldo(2000.00)
                .build();

        System.out.println(e3.getResumen());
        
        
        

    }
}
