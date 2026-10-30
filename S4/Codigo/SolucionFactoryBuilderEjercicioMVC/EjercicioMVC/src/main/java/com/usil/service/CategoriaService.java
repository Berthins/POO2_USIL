package com.usil.service;

import com.usil.model.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    private final List<Categoria> categorias = new ArrayList<>();
    private int contadorId = 1;

    public Categoria registrarCategoria(String nombre, String descripcion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoria es obligatorio");
        }
        Categoria categoria = new Categoria(contadorId++, nombre.trim(), descripcion);
        categorias.add(categoria);
        return categoria;
    }

    public List<Categoria> listarCategorias() {
        return categorias;
    }

    public Categoria buscarPorId(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public boolean actualizarCategoria(int id, String nombre, String descripcion) {
        Categoria categoria = buscarPorId(id);
        if (categoria == null) {
            return false;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la categoria es obligatorio");
        }
        categoria.setNombre(nombre.trim());
        categoria.setDescripcion(descripcion);
        return true;
    }

    public boolean eliminarCategoria(int id) {
        Categoria categoria = buscarPorId(id);
        if (categoria == null) {
            return false;
        }
        return categorias.remove(categoria);
    }

}
