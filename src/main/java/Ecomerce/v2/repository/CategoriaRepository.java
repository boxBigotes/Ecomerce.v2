package Ecomerce.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    //Categoria_deleteByNombre
    void Categoria_deleteByNombre(String nombre);
}
