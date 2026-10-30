package builder;

public class Empleado {
    private final String nombre;
    private final String puesto;
    private final String area;
    private final Double sueldo;
    
    private Empleado(EmpleadoBuilder builder){
        this.nombre = builder.nombre;
        this.puesto = builder.puesto;
        this.area = builder.area;
        this.sueldo = builder.sueldo;
    }
    
    public String getResumen(){
        return "Empleado:"+nombre +"-Puesto "+puesto;
    }
    
    public static class EmpleadoBuilder{
        private final String nombre;
        private final String puesto;
        private  Double sueldo = 0.0;
        private  String area  ="sin asignar";
        
        public EmpleadoBuilder(String nombre, String puesto){
            this.nombre = nombre;
            this.puesto = puesto;
        }
        
        public EmpleadoBuilder conArea(String area){
            this.area = area;
            return this;
        }
        
        public EmpleadoBuilder conSueldo(Double sueldo){
            this.sueldo = sueldo;
            return this;
        }
        
        
        public Empleado build(){
            return new Empleado(this);
        }
    }
}

