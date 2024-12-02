package Ecomerce.v2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecomerce.v2.entitties.Encargado;
import Ecomerce.v2.repository.EncargadoRepository;

@Service
public class EncargadoService {
    
    @Autowired
    private EncargadoRepository encargadoRepository;

    public boolean autenticar(String nombre, String password) {
        Optional<Encargado> encargado = encargadoRepository.findByNombre(nombre);
        return encargado.isPresent() && encargado.get().getPassword().equals(password);
    }

   
}
