package Ecomerce.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.v2.entitties.Cliente;
import Ecomerce.v2.services.ClienteService;
import Ecomerce.v2.services.EncargadoService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private final ClienteService clienteService;

    
    public AuthController(ClienteService clienteService, EncargadoService encargadoService) {
        this.clienteService = clienteService;
        
    }

    // Login para Cliente
    @PostMapping("/cliente/login")
    public Cliente loginCliente(@RequestBody Cliente cliente) {
        // Realizar la autenticación del Cliente
        return clienteService.authenticate(cliente.getNombre(), cliente.getPassword());
    }
}
