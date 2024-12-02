package Ecomerce.v2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Ecomerce.v2.entitties.Pedido;
import Ecomerce.v2.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //Pedidos_All
    public List<Pedido> Pedido_All() {
        return pedidoRepository.findAll();
    }

    //Pedidos_findById
    public Optional<Pedido> Pedido_findById(Long id) {
        return pedidoRepository.findById(id);
    }

    //Pedido_save
    public Pedido Pedido_save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    //Pedido_deleteById
    public void Pedido_deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

}
