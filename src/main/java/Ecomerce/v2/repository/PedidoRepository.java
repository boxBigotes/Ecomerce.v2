package Ecomerce.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.v2.entitties.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
