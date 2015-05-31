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
@Table(name = "detalle_factura_venta_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFacturaVentaProducto.findAll", query = "SELECT d FROM DetalleFacturaVentaProducto d"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByIdDetalleFacturaVentaProducto", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.idDetalleFacturaVentaProducto = :idDetalleFacturaVentaProducto"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByCantidad", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByPrecioVenta", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByDescuento", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findBySubTotal", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.subTotal = :subTotal"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByFechaRegistro", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleFacturaVentaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_factura_venta_producto")
    private Integer idDetalleFacturaVentaProducto;
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
    @JoinColumn(name = "id_factura_venta", referencedColumnName = "id_factura_venta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FacturaVenta facturaVenta;

    public DetalleFacturaVentaProducto() {
    }

    public DetalleFacturaVentaProducto(Integer idDetalleFacturaVentaProducto) {
        this.idDetalleFacturaVentaProducto = idDetalleFacturaVentaProducto;
    }

    public DetalleFacturaVentaProducto(Integer idDetalleFacturaVentaProducto, int cantidad, BigDecimal precioVenta, BigDecimal descuento, BigDecimal subTotal, int estadoExistencia) {
        this.idDetalleFacturaVentaProducto = idDetalleFacturaVentaProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdDetalleFacturaVentaProducto() {
        return idDetalleFacturaVentaProducto;
    }

    public void setIdDetalleFacturaVentaProducto(Integer idDetalleFacturaVentaProducto) {
        this.idDetalleFacturaVentaProducto = idDetalleFacturaVentaProducto;
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

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFacturaVentaProducto != null ? idDetalleFacturaVentaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaVentaProducto)) {
            return false;
        }
        DetalleFacturaVentaProducto other = (DetalleFacturaVentaProducto) object;
        if ((this.idDetalleFacturaVentaProducto == null && other.idDetalleFacturaVentaProducto != null) || (this.idDetalleFacturaVentaProducto != null && !this.idDetalleFacturaVentaProducto.equals(other.idDetalleFacturaVentaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFacturaVentaProducto[ idDetalleFacturaVentaProducto=" + idDetalleFacturaVentaProducto + " ]";
    }
    
}
