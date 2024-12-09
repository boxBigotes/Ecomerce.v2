package Ecomerce.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Método para encontrar un Cliente por su nombre
    Cliente findByNombre(String nombre);

    // Método para eliminar un Cliente por su nombre
    void deleteByNombre(String nombre);
}
