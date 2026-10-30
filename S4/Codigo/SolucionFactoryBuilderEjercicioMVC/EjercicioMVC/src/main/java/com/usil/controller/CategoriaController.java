package com.usil.controller;

import com.usil.model.Categoria;
import com.usil.service.CategoriaService;
import java.util.List;

public class CategoriaController {

    private final CategoriaService categoriaService = new CategoriaService();

    //Peticion (REQUEST) registrar una categoria
    public Categoria registrarCategoria(String nombre, String descripcion) {
        return categoriaService.registrarCategoria(nombre, descripcion);
    }

    //Peticion (REQUEST) listar las categorias
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    //Peticion (REQUEST) buscar una categoria por id
    public Categoria buscarPorId(int id) {
        return categoriaService.buscarPorId(id);
    }

    //Peticion (REQUEST) actualizar una categoria
    public boolean actualizarCategoria(int id, String nombre, String descripcion) {
        return categoriaService.actualizarCategoria(id, nombre, descripcion);
    }

    //Peticion (REQUEST) eliminar una categoria
    public boolean eliminarCategoria(int id) {
        return categoriaService.eliminarCategoria(id);
    }

}
