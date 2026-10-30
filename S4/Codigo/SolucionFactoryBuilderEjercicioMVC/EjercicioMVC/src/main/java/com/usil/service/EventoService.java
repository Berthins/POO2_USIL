package com.usil.service;

import com.usil.model.Categoria;
import com.usil.model.Evento;
import java.util.ArrayList;
import java.util.List;

public class EventoService {

    private final List<Evento> eventos = new ArrayList<>();
    private int contadorId = 1;

    public Evento registrarEvento(String nombre, String fecha, String lugar, Categoria categoria) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento es obligatorio");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoria para el evento");
        }
        Evento evento = new Evento(contadorId++, nombre.trim(), fecha, lugar, categoria);
        eventos.add(evento);
        return evento;
    }

    public List<Evento> listarEventos() {
        return eventos;
    }

    public Evento buscarPorId(int id) {
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return evento;
            }
        }
        return null;
    }

    public boolean actualizarEvento(int id, String nombre, String fecha, String lugar, Categoria categoria) {
        Evento evento = buscarPorId(id);
        if (evento == null) {
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento es obligatorio");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Debe seleccionar una categoria para el evento");
        }
        evento.setNombre(nombre.trim());
        evento.setFecha(fecha);
        evento.setLugar(lugar);
        evento.setCategoria(categoria);
        return true;
    }

    public boolean eliminarEvento(int id) {
        Evento evento = buscarPorId(id);
        if (evento == null) {
            return false;
        }
        return eventos.remove(evento);
    }

}
