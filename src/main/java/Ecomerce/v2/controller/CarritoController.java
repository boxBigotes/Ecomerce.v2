package Ecomerce.v2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Ecomerce.v2.entitties.Carrito;
import Ecomerce.v2.services.CarritoService;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    private final CarritoService carritoService;

    // Inyección del servicio en el controlador
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // Obtener todos los carritos
    @GetMapping
    public List<Carrito> obtenerTodos() {
        return carritoService.Carrito_findAll();
    }

    // Obtener carrito por ID
    @GetMapping("/{id}")
    public Carrito obtenerPorId(@PathVariable Long id) {
    return carritoService.Carrito_findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrito no encontrado"));
    }

    // Eliminar un carrito por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoService.Carrito_deleteById(id);
    }
}

