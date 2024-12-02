package Ecomerce.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.v2.entitties.Cliente;
import Ecomerce.v2.repository.ClienteRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private ClienteRepository clienteRepository;

    
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody Cliente cliente) {
        
        Cliente existingCliente = clienteRepository.Cliente_findByNombre(cliente.getNombre());
        
        if (existingCliente != null && existingCliente.getPassword().equals(cliente.getPassword())) {
            
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}
