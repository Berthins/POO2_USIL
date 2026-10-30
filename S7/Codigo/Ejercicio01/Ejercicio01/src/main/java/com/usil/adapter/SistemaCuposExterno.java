package com.usil.adapter;

import java.util.Map;

public class SistemaCuposExterno {

    private static final Map<String, String> CUPOS = Map.of(
        "CUSCO", "CUSCO:12:ALTA",
        "AREQUIPA", "AREQUIPA:8:MEDIA",
        "PARACAS", "PARACAS:20:BAJA");

    public String consultar(String destino) {
        return CUPOS.get(destino);
    }
}
