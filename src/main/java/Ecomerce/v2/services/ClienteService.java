package Ecomerce.v2.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Ecomerce.v2.entitties.Cliente;
import Ecomerce.v2.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    }

    // Guardar un nuevo cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar cliente por ID
    public void deleteClienteById(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        clienteRepository.deleteById(id);
    }

    // Buscar cliente por nombre
    public Cliente getClienteByNombre(String nombre) {
        Cliente cliente = clienteRepository.findByNombre(nombre);
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        return cliente;
    }

    // Eliminar cliente por nombre
    public void deleteClienteByNombre(String nombre) {
        Cliente cliente = clienteRepository.findByNombre(nombre);
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        clienteRepository.deleteByNombre(nombre);
    }

    // Método de autenticación
    public Cliente authenticate(String nombre, String password) {
        Cliente cliente = clienteRepository.findByNombre(nombre);
        if (cliente == null || !cliente.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
        }
        return cliente;
    }
}
