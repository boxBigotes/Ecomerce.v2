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

import Ecomerce.v2.entitties.PedidoProducto;
import Ecomerce.v2.services.PedidoProductoService;

@RestController
@RequestMapping("/pedido-productos")
public class PedidoProductoController {

    private final PedidoProductoService pedidoProductoService;

    public PedidoProductoController(PedidoProductoService pedidoProductoService) {
        this.pedidoProductoService = pedidoProductoService;
    }

    //PedidoProducto_findAll
    @GetMapping
    public List<PedidoProducto> PedidoProducto_findAll() {
        return pedidoProductoService.PedidoProducto_findAll();
    }


    //PedidoProducto_findById
    @GetMapping("/{id}")
    public PedidoProducto PedidoProducto_findById(@PathVariable Long id) {
        return pedidoProductoService.PedidoProducto_findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PedidoProducto no encontrado"));
    }
    

    // PedidoProducto_save
    @PostMapping
    public PedidoProducto PedidoProducto_save(@RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoService.PedidoProducto_save(pedidoProducto);
    }

    // PedidoProducto_deleteById
    @DeleteMapping("/{id}")
    public void PedidoProducto_deleteById(@PathVariable Long id) {
        pedidoProductoService.PedidoProducto_deleteById(id);
    }


    // Eliminar todos los productos asociados a un producto
    @DeleteMapping("/producto/{productoId}")
    public void PedidoProducto_deleteByProductoId(@PathVariable Long productoId) {
        pedidoProductoService.PedidoProducto_deleteById(productoId);
    }
}

