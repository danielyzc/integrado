/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "detalle_orden_compra_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleOrdenCompraProducto.findAll", query = "SELECT d FROM DetalleOrdenCompraProducto d"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByIdOrdenCompra", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.detalleOrdenCompraProductoPK.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByIdProducto", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.detalleOrdenCompraProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByCantidad", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByPrecioVenta", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByDescuento", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findBySubTotal", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleOrdenCompraProducto.findByFechaRegistro", query = "SELECT d FROM DetalleOrdenCompraProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleOrdenCompraProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleOrdenCompraProductoPK detalleOrdenCompraProductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private BigDecimal subTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrdenCompra ordenCompra;

    public DetalleOrdenCompraProducto() {
    }

    public DetalleOrdenCompraProducto(DetalleOrdenCompraProductoPK detalleOrdenCompraProductoPK) {
        this.detalleOrdenCompraProductoPK = detalleOrdenCompraProductoPK;
    }

    public DetalleOrdenCompraProducto(DetalleOrdenCompraProductoPK detalleOrdenCompraProductoPK, int cantidad, BigDecimal precioVenta, BigDecimal descuento, BigDecimal subTotal, int estadoExistencia) {
        this.detalleOrdenCompraProductoPK = detalleOrdenCompraProductoPK;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.estadoExistencia = estadoExistencia;
    }

    public DetalleOrdenCompraProducto(int idOrdenCompra, int idProducto) {
        this.detalleOrdenCompraProductoPK = new DetalleOrdenCompraProductoPK(idOrdenCompra, idProducto);
    }

    public DetalleOrdenCompraProductoPK getDetalleOrdenCompraProductoPK() {
        return detalleOrdenCompraProductoPK;
    }

    public void setDetalleOrdenCompraProductoPK(DetalleOrdenCompraProductoPK detalleOrdenCompraProductoPK) {
        this.detalleOrdenCompraProductoPK = detalleOrdenCompraProductoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public int getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(int estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleOrdenCompraProductoPK != null ? detalleOrdenCompraProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenCompraProducto)) {
            return false;
        }
        DetalleOrdenCompraProducto other = (DetalleOrdenCompraProducto) object;
        if ((this.detalleOrdenCompraProductoPK == null && other.detalleOrdenCompraProductoPK != null) || (this.detalleOrdenCompraProductoPK != null && !this.detalleOrdenCompraProductoPK.equals(other.detalleOrdenCompraProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleOrdenCompraProducto[ detalleOrdenCompraProductoPK=" + detalleOrdenCompraProductoPK + " ]";
    }
    
}
