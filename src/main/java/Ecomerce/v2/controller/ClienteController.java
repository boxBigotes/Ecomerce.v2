package Ecomerce.v2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.v2.entitties.Cliente;
import Ecomerce.v2.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Cliente_findAll
    @GetMapping
    public List<Cliente> Cliente_findAll() {
        return clienteService.Cliente_All();
    }

    // Cliente_findById
    @GetMapping("/{id}")
    public Optional<Cliente> Cliente_findById(@PathVariable Long id) {
        return clienteService.Cliente_findById(id);
    }

    //Cliente_findByNombre
    @GetMapping("/nombre/{nombre}")
    public Cliente Cliente_findByNombre(@PathVariable String nombre) {
        return clienteService.Cliente_findByNombre(nombre);
    }

    // Crear o actualizar cliente
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.Cliente_save(cliente);
    }

    // Cliente_deleteById
    @DeleteMapping("/{id}")
    public void Cliente_deleteById(@PathVariable Long id) {
        clienteService.Cliente_deleteById(id);
    }

    //Cliente_deleteByNombre
    @DeleteMapping("/{nombre}")
    public void Cliente_deleteByNombre(@PathVariable String nombre) {
        clienteService.Cliente_deleteByNombre(nombre);
    }

}


