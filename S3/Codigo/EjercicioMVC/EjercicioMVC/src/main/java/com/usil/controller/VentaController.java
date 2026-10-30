package com.usil.controller;

import com.usil.model.Venta;

public class VentaController {
    Venta venta ;
    
    //Peticion (REQUEST) registrar una venta
    public double registrarVenta(int cantidad, double precio){
        venta = new Venta(cantidad, precio);
        return venta.calcularSubtotal();
    }
    
}
