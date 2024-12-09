package Ecomerce.v2.entitties;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoProductoId implements Serializable {

    private Long pedidoId;
    private Long productoId;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProductoId() {
        return productoId;
    }

      public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PedidoProductoId that = (PedidoProductoId) obj;
        return pedidoId.equals(that.pedidoId) && productoId.equals(that.productoId);
    }

    @Override
    public int hashCode() {
        return 31 * pedidoId.hashCode() + productoId.hashCode();
    }

}    