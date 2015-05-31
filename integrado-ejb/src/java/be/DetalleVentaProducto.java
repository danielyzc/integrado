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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "detalle_venta_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVentaProducto.findAll", query = "SELECT d FROM DetalleVentaProducto d"),
    @NamedQuery(name = "DetalleVentaProducto.findByIdDetalleVentaProducto", query = "SELECT d FROM DetalleVentaProducto d WHERE d.idDetalleVentaProducto = :idDetalleVentaProducto"),
    @NamedQuery(name = "DetalleVentaProducto.findByCantidad", query = "SELECT d FROM DetalleVentaProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVentaProducto.findByPrecioVenta", query = "SELECT d FROM DetalleVentaProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleVentaProducto.findByDescuento", query = "SELECT d FROM DetalleVentaProducto d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleVentaProducto.findBySubTotal", query = "SELECT d FROM DetalleVentaProducto d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "DetalleVentaProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleVentaProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleVentaProducto.findByFechaRegistro", query = "SELECT d FROM DetalleVentaProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleVentaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_venta_producto")
    private Integer idDetalleVentaProducto;
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
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Venta venta;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(Integer idDetalleVentaProducto) {
        this.idDetalleVentaProducto = idDetalleVentaProducto;
    }

    public DetalleVentaProducto(Integer idDetalleVentaProducto, int cantidad, BigDecimal precioVenta, BigDecimal descuento, BigDecimal subTotal, int estadoExistencia) {
        this.idDetalleVentaProducto = idDetalleVentaProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdDetalleVentaProducto() {
        return idDetalleVentaProducto;
    }

    public void setIdDetalleVentaProducto(Integer idDetalleVentaProducto) {
        this.idDetalleVentaProducto = idDetalleVentaProducto;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVentaProducto != null ? idDetalleVentaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaProducto)) {
            return false;
        }
        DetalleVentaProducto other = (DetalleVentaProducto) object;
        if ((this.idDetalleVentaProducto == null && other.idDetalleVentaProducto != null) || (this.idDetalleVentaProducto != null && !this.idDetalleVentaProducto.equals(other.idDetalleVentaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleVentaProducto[ idDetalleVentaProducto=" + idDetalleVentaProducto + " ]";
    }
    
}
