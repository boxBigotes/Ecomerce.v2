package Ecomerce.v2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.PedidoProducto;

@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long>{
    
    //PedidoProducto_findByProductoNombre
    List<PedidoProducto> findAllByPedidonombre(String nombre);

    //PedidoProducto_deleteByNombre
    void PedidoProducto_deleteByNombre(String nombre);
}
