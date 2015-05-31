/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o"),
    @NamedQuery(name = "OrdenCompra.findByIdOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaCreacionOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaCreacionOrdenCompra = :fechaCreacionOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaEntregaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaEntregaOrdenCompra = :fechaEntregaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByTotalOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.totalOrdenCompra = :totalOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByTotalPagosCreditoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.totalPagosCreditoOrdenCompra = :totalPagosCreditoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByObservaciones", query = "SELECT o FROM OrdenCompra o WHERE o.observaciones = :observaciones"),
    @NamedQuery(name = "OrdenCompra.findByFechaRegistro", query = "SELECT o FROM OrdenCompra o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OrdenCompra.findByEstadoExistencia", query = "SELECT o FROM OrdenCompra o WHERE o.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "OrdenCompra.findByFechaModificacion", query = "SELECT o FROM OrdenCompra o WHERE o.fechaModificacion = :fechaModificacion")})
public class OrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden_compra")
    private Integer idOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion_orden_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega_orden_compra")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaOrdenCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_orden_compra")
    private BigDecimal totalOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_pagos_credito_orden_compra")
    private BigDecimal totalPagosCreditoOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proveedor proveedor;
    @JoinColumn(name = "id_estado_facturacion_orden_compra", referencedColumnName = "id_estado_facturacion_orden_compra")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra;
    @JoinColumn(name = "id_estado_orden_compra", referencedColumnName = "id_estado_orden_compra")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoOrdenCompra estadoOrdenCompra;
    @OneToMany(mappedBy = "ordenCompra", fetch = FetchType.EAGER)
    private List<PagoCompraCredito> pagoCompraCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturaCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.EAGER)
    private List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.EAGER)
    private List<CanjeOrdenCompra> canjeOrdenCompraList;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public OrdenCompra(Integer idOrdenCompra, Date fechaCreacionOrdenCompra, Date fechaEntregaOrdenCompra, BigDecimal totalOrdenCompra, BigDecimal totalPagosCreditoOrdenCompra, String observaciones, int estadoExistencia) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaCreacionOrdenCompra = fechaCreacionOrdenCompra;
        this.fechaEntregaOrdenCompra = fechaEntregaOrdenCompra;
        this.totalOrdenCompra = totalOrdenCompra;
        this.totalPagosCreditoOrdenCompra = totalPagosCreditoOrdenCompra;
        this.observaciones = observaciones;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Date getFechaCreacionOrdenCompra() {
        return fechaCreacionOrdenCompra;
    }

    public void setFechaCreacionOrdenCompra(Date fechaCreacionOrdenCompra) {
        this.fechaCreacionOrdenCompra = fechaCreacionOrdenCompra;
    }

    public Date getFechaEntregaOrdenCompra() {
        return fechaEntregaOrdenCompra;
    }

    public void setFechaEntregaOrdenCompra(Date fechaEntregaOrdenCompra) {
        this.fechaEntregaOrdenCompra = fechaEntregaOrdenCompra;
    }

    public BigDecimal getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(BigDecimal totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }

    public BigDecimal getTotalPagosCreditoOrdenCompra() {
        return totalPagosCreditoOrdenCompra;
    }

    public void setTotalPagosCreditoOrdenCompra(BigDecimal totalPagosCreditoOrdenCompra) {
        this.totalPagosCreditoOrdenCompra = totalPagosCreditoOrdenCompra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(int estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1) {
        this.empleado1 = empleado1;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EstadoFacturacionOrdenCompra getEstadoFacturacionOrdenCompra() {
        return estadoFacturacionOrdenCompra;
    }

    public void setEstadoFacturacionOrdenCompra(EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra) {
        this.estadoFacturacionOrdenCompra = estadoFacturacionOrdenCompra;
    }

    public EstadoOrdenCompra getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    @XmlTransient
    public List<PagoCompraCredito> getPagoCompraCreditoList() {
        return pagoCompraCreditoList;
    }

    public void setPagoCompraCreditoList(List<PagoCompraCredito> pagoCompraCreditoList) {
        this.pagoCompraCreditoList = pagoCompraCreditoList;
    }

    @XmlTransient
    public List<FacturaCompra> getFacturaCompraList() {
        return facturaCompraList;
    }

    public void setFacturaCompraList(List<FacturaCompra> facturaCompraList) {
        this.facturaCompraList = facturaCompraList;
    }

    @XmlTransient
    public List<DetalleOrdenCompraProducto> getDetalleOrdenCompraProductoList() {
        return detalleOrdenCompraProductoList;
    }

    public void setDetalleOrdenCompraProductoList(List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList) {
        this.detalleOrdenCompraProductoList = detalleOrdenCompraProductoList;
    }

    @XmlTransient
    public List<CanjeOrdenCompra> getCanjeOrdenCompraList() {
        return canjeOrdenCompraList;
    }

    public void setCanjeOrdenCompraList(List<CanjeOrdenCompra> canjeOrdenCompraList) {
        this.canjeOrdenCompraList = canjeOrdenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.OrdenCompra[ idOrdenCompra=" + idOrdenCompra + " ]";
    }
    
}
