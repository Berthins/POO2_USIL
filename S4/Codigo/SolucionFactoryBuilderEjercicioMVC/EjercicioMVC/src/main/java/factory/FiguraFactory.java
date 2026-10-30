package factory;

public class FiguraFactory {
    
    //Factory Method => static
    public static Figura crearFigura(TipoFigura tipoFigura){
        switch (tipoFigura) {
            case CIRCULO:
                return new Circulo();
            case CUADRADO:
                return new Cuadrado();
            case TRIANGULO:
                return new Triangulo();
            default:
                throw new IllegalArgumentException("Figura no soportada "+tipoFigura);
        }
    }
    
    
}
