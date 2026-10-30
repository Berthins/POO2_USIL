package factory;

public class Main {
    public static void main(String[] args) {
        Figura f1 = FiguraFactory.crearFigura(TipoFigura.CIRCULO);
        Figura f2 = FiguraFactory.crearFigura(TipoFigura.CUADRADO);
        
        f1.dibujar();
        f2.dibujar();
    }
}
