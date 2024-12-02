package Ecomerce.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //Cliente_findByNombre
    Cliente Cliente_findByNombre(String nombre);

    //Cliente_deleteByNombre
    void Cliente_deleteByNombre(String nombre);
}
