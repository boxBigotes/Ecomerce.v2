package Ecomerce.v2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Encargado;

@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Long> {
    //Encargado_findByNombre
    Optional<Encargado> findByNombre(String nombre);

    //Encargado_deleteByNombre
    void deleteByNombre(String nombre);

}