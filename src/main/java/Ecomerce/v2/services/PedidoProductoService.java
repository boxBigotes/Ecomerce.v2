package Ecomerce.v2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Ecomerce.v2.entitties.PedidoProducto;
import Ecomerce.v2.repository.PedidoProductoRepository;

@Service
public class PedidoProductoService {

    private final PedidoProductoRepository pedidoProductoRepository;

    public PedidoProductoService(PedidoProductoRepository pedidoProductoRepository) {
        this.pedidoProductoRepository = pedidoProductoRepository;
    }

    //PedidoProducto_findAll
    public List<PedidoProducto> PedidoProducto_findAll() {
        return pedidoProductoRepository.findAll();
    }

    //PedidoProducto_findById
    public Optional<PedidoProducto> PedidoProducto_findById(Long id) {
        return pedidoProductoRepository.findById(id);
    }

    //PedidoProducto_save
    public PedidoProducto PedidoProducto_save(PedidoProducto pedidoProducto) {
        return pedidoProductoRepository.save(pedidoProducto);
    }

    //PedidoProducto_deleteById
    public void PedidoProducto_deleteById(Long id) {
        pedidoProductoRepository.deleteById(id);
    }
    
    //PedidoProducto_deleteByNombre
    public void PedidoProducto_deleteByNombre(String nombreProducto) {
        pedidoProductoRepository.PedidoProducto_deleteByNombre(nombreProducto);
    }

    // PedidoProducto_findByPedidoNombre
    public List<PedidoProducto> PedidoProducto_findByPedidonombre(String nombre) {
        return pedidoProductoRepository.findAllByPedidonombre(nombre);
    }
    

}