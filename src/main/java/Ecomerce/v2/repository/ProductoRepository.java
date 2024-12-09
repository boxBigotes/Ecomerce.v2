package Ecomerce.v2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Producto_findByCategoriaNombre
    List<Producto> findByCategoriaNombre(String nombre);

    //Producto_deleteByNombre
    void deleteByNombre(String nombre);
}
