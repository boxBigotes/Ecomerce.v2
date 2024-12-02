package Ecomerce.v2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.v2.entitties.Producto;
import Ecomerce.v2.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //Producto_findAll
    @GetMapping
    public List<Producto> Producto_findAll() {
        return productoService.Producto_findAll();
    }

    //Producto_findById
    @GetMapping("/{id}")
    public ResponseEntity<Producto> Producto_findById(@PathVariable Long id) {
        return productoService.Producto_findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Producto_save (actualizar o crear)
    @PostMapping
    public Producto Producto_save(@RequestBody Producto producto) {
        return productoService.Producto_save(producto);
    }
    
    //Producto_deleteById
    @DeleteMapping("/{id}")
    public void Producto_deleteById(@PathVariable Long id) {
        productoService.Producto_deleteById(id);
    }

    //Producto_deleteByNombre
    @DeleteMapping("/nombre/{nombre}")
    public void Producto_deleteByNombre(@PathVariable String nombre) {
        productoService.Producto_deleteByNombre(nombre);
    }

    //Producto_findByCategoriaNombre
    @GetMapping("/categoria/{nombre}")
    public List<Producto> obtenerPorNombreCategoria(@PathVariable String nombre) {
        return productoService.Producto_findByCategoriaNombre(nombre);
    }
}
