package Ecomerce.v2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    // Crear un nuevo cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteById(@PathVariable Long id) {
        clienteService.deleteClienteById(id);
    }

    // Obtener un cliente por nombre
    @GetMapping("/nombre/{nombre}")
    public Cliente getClienteByNombre(@PathVariable String nombre) {
        return clienteService.getClienteByNombre(nombre);
    }

    // Eliminar un cliente por nombre
    @DeleteMapping("/nombre/{nombre}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteByNombre(@PathVariable String nombre) {
        clienteService.deleteClienteByNombre(nombre);
    }
}
