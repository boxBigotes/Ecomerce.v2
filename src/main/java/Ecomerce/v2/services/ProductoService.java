package Ecomerce.v2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Ecomerce.v2.entitties.Producto;
import Ecomerce.v2.repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Producto_findAll
    public List<Producto> Producto_findAll() {
        return productoRepository.findAll();
    }

    //Producto_findById
    public Optional<Producto> Producto_findById(Long id) {
        return productoRepository.findById(id);
    }

    //Producto_save
    public Producto Producto_save(Producto producto) {
        return productoRepository.save(producto);
    }

    //Producto_deleteById
    public void Producto_deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    //Producto_findByCategoriaNombre
    public List<Producto> Producto_findByCategoriaNombre(String nombre) {
        return productoRepository.Producto_findByCategoriaNombre(nombre);
    }

    //Producto_deleteByNombre
    public void Producto_deleteByNombre(String nombre) {
        productoRepository.Producto_deleteByNombre(nombre);
    }
}
