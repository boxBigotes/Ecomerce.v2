package Ecomerce.v2.entitties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoProducto {

    @EmbeddedId
    private PedidoProductoId id;  // Esto actúa como la clave compuesta

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "pedidoId", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "productoId", insertable = false, updatable = false)
    private Producto producto;

    private Integer cantidad;
    private Double precio;
    public PedidoProductoId getId() {
        return id;
    }
    public void setId(PedidoProductoId id) {
        this.id = id;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}