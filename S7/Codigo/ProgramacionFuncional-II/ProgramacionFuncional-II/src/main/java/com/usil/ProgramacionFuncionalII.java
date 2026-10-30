package com.usil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramacionFuncionalII {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        
        //Mostrar los elementos del Arraylist inicial elevados al cuadros
        //1x1 = 1
        //2x2 = 4
        //map => operacion que me permite realiza transformacion
        numeros.stream()//stream (numeros)
                .map(x->x*x) //stream (numeros elevados al cuadrado)
                //.sum()
                .forEach(y->System.out.println(y));
        
        
        //Obtener la suma de los elementos impares
        int resultado =numeros.stream()
                .filter(x-> x%2!=0)//stream filtrado con numeros impares
                //reduce = 0 ->1,3 => 3
                //reduce = 4 ->5,7 => 16
                //reduce = 16 ->9 => 25
                .reduce(0, (a,b)-> a + b);
        System.out.println(resultado);
        
        
        List<String> nombres = Arrays.asList("Henry","Ana","Maria", "Angelica");
        nombres.stream()
                .filter(nombre->nombre.startsWith("A"))
                .forEach(y->System.out.println(y));
        
        
        List<Producto> productos = List.of(
                
          new Producto (1,"Laptop",3500.0,10),
          new Producto (2,"Mouse",45.0,0),
          new Producto (3,"Monitor",850.0,5),
          new Producto (4,"Licuadora",220.0,8),
          new Producto (5,"Sarten",60.0,0),
          new Producto (6,"Silla ergonomica",650.0,3),
          new Producto (7,"Archivador",120.0,12)
        );
               
        
        List<Producto> productosCaros = productos.stream()
                .filter(p->p.getPrecio() > 500)
                .collect(Collectors.toList());
        
        System.out.println("Productos con precio mayor a S/.500");
        productosCaros.forEach(System.out::println);
              
        List<String> nombreProductos = productos.stream() //stream<Producto>
                .map(p->p.getNombre().toUpperCase()) //stream<String>
                .toList();
        
        System.out.println("Nombre de productos en mayuscula");
        nombreProductos.forEach(System.out::println);
        
    }
}
