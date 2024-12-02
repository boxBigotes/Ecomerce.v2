package Ecomerce.v2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Ecomerce.v2.entitties.Categoria;
import Ecomerce.v2.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Obtener todas las categorías
    @GetMapping
    public List<Categoria> Categorias_All() {
        return categoriaService.Categorias_All();
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable Long id) {
        return categoriaService.Categoria_findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada"));
    }

    // Crear una nueva categoría
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.Categoria_save(categoria);
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public void eliminarCategoriaPorId(@PathVariable Long id) {
        categoriaService.Categoria_deleteById(id);
    }

    // Eliminar una categoría por nombre
    @DeleteMapping("/nombre/{nombre}")
    public void eliminarCategoriaPorNombre(@PathVariable String nombre) {
        categoriaService.Categoria_deleteByNombre(nombre);
    }

}
