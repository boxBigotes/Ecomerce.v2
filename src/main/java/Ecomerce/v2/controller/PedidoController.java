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

import Ecomerce.v2.entitties.Pedido;
import Ecomerce.v2.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    // Constructor de inyección de dependencias
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedido> Pedido_findAll() {
        return pedidoService.Pedido_All();
    }

    // Obtener pedido por ID
    @GetMapping("/{id}")
    public Pedido Pedido_findById(@PathVariable Long id) {
        return pedidoService.Pedido_findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado"));
    }

    // Crear o actualizar un pedido
    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.Pedido_save(pedido);
    }

    // Eliminar un pedido por ID
    @DeleteMapping("/{id}")
    public void Pedido_deleteById(@PathVariable Long id) {
        pedidoService.Pedido_deleteById(id);
    }

}


