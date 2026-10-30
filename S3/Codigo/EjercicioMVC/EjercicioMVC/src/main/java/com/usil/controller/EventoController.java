package com.usil.controller;

import com.usil.model.Categoria;
import com.usil.model.Evento;
import com.usil.service.EventoService;
import java.util.List;

public class EventoController {

    private final EventoService eventoService = EventoService.getInstance();

    //Peticion (REQUEST) registrar un evento
    public Evento registrarEvento(String nombre, String fecha, String lugar, Categoria categoria) {
        return eventoService.registrarEvento(nombre, fecha, lugar, categoria);
    }

    //Peticion (REQUEST) listar los eventos
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    //Peticion (REQUEST) buscar un evento por id
    public Evento buscarPorId(int id) {
        return eventoService.buscarPorId(id);
    }

    //Peticion (REQUEST) actualizar un evento
    public boolean actualizarEvento(int id, String nombre, String fecha, String lugar, Categoria categoria) {
        return eventoService.actualizarEvento(id, nombre, fecha, lugar, categoria);
    }

    //Peticion (REQUEST) eliminar un evento
    public boolean eliminarEvento(int id) {
        return eventoService.eliminarEvento(id);
    }

}
