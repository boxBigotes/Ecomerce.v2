package Ecomerce.v2.services;

import java.util.List;
import java.util.Optional;

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

    //Cliente_All
    public List<Cliente> Cliente_All() {
        return clienteRepository.findAll();
    }

    //Cliente_findById
    public Optional<Cliente> Cliente_findById(Long id) {
        return clienteRepository.findById(id);
    }

    //Cliente_save
    public Cliente Cliente_save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Cliente_deleteById
    public void Cliente_deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    //Cliente_findByNombre
    public Cliente Cliente_findByNombre(String nombre) {
        Cliente cliente = clienteRepository.Cliente_findByNombre(nombre);
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        return cliente;
    }

    //Cliente_deleteByNombre
     public void Cliente_deleteByNombre(String nombre) {
        clienteRepository.Cliente_deleteByNombre(nombre);
    }

}
