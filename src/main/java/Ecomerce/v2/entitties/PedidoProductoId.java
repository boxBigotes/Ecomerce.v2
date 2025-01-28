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
        return (pedidoId != null ? pedidoId.equals(that.pedidoId) : that.pedidoId == null) && 
               (productoId != null ? productoId.equals(that.productoId) : that.productoId == null);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (pedidoId != null ? pedidoId.hashCode() : 0);
        result = 31 * result + (productoId != null ? productoId.hashCode() : 0);
        return result;
    }
    

}    