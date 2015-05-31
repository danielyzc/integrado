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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByBloqueVenta", query = "SELECT v FROM Venta v WHERE v.bloqueVenta = :bloqueVenta"),
    @NamedQuery(name = "Venta.findByNumeroVenta", query = "SELECT v FROM Venta v WHERE v.numeroVenta = :numeroVenta"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByFechaVentaEmision", query = "SELECT v FROM Venta v WHERE v.fechaVentaEmision = :fechaVentaEmision"),
    @NamedQuery(name = "Venta.findByTotalVenta", query = "SELECT v FROM Venta v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "Venta.findByObservaciones", query = "SELECT v FROM Venta v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "Venta.findByTotalPagosCredito", query = "SELECT v FROM Venta v WHERE v.totalPagosCredito = :totalPagosCredito"),
    @NamedQuery(name = "Venta.findByFacturaRelacionada", query = "SELECT v FROM Venta v WHERE v.facturaRelacionada = :facturaRelacionada"),
    @NamedQuery(name = "Venta.findByEstadoExistencia", query = "SELECT v FROM Venta v WHERE v.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "Venta.findByFechaModificacion", query = "SELECT v FROM Venta v WHERE v.fechaModificacion = :fechaModificacion")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bloque_venta")
    private int bloqueVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_venta")
    private int numeroVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVentaEmision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_venta")
    private BigDecimal totalVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_pagos_credito")
    private BigDecimal totalPagosCredito;
    @Size(max = 50)
    @Column(name = "factura_relacionada")
    private String facturaRelacionada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<ContratoFumigacion> contratoFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<Cambio> cambioList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_estado_venta", referencedColumnName = "id_estado_venta")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoVenta estadoVenta;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;
    @JoinColumn(name = "id_tipo_venta", referencedColumnName = "id_tipo_venta")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoVenta tipoVenta;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
    private List<NotaCredito> notaCreditoList;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, int bloqueVenta, int numeroVenta, Date fechaVenta, Date fechaVentaEmision, BigDecimal totalVenta, String observaciones, BigDecimal totalPagosCredito, int estadoExistencia) {
        this.idVenta = idVenta;
        this.bloqueVenta = bloqueVenta;
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
        this.fechaVentaEmision = fechaVentaEmision;
        this.totalVenta = totalVenta;
        this.observaciones = observaciones;
        this.totalPagosCredito = totalPagosCredito;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getBloqueVenta() {
        return bloqueVenta;
    }

    public void setBloqueVenta(int bloqueVenta) {
        this.bloqueVenta = bloqueVenta;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVentaEmision() {
        return fechaVentaEmision;
    }

    public void setFechaVentaEmision(Date fechaVentaEmision) {
        this.fechaVentaEmision = fechaVentaEmision;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTotalPagosCredito() {
        return totalPagosCredito;
    }

    public void setTotalPagosCredito(BigDecimal totalPagosCredito) {
        this.totalPagosCredito = totalPagosCredito;
    }

    public String getFacturaRelacionada() {
        return facturaRelacionada;
    }

    public void setFacturaRelacionada(String facturaRelacionada) {
        this.facturaRelacionada = facturaRelacionada;
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

    @XmlTransient
    public List<ContratoFumigacion> getContratoFumigacionList() {
        return contratoFumigacionList;
    }

    public void setContratoFumigacionList(List<ContratoFumigacion> contratoFumigacionList) {
        this.contratoFumigacionList = contratoFumigacionList;
    }

    @XmlTransient
    public List<Cambio> getCambioList() {
        return cambioList;
    }

    public void setCambioList(List<Cambio> cambioList) {
        this.cambioList = cambioList;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList() {
        return pagoVentaCreditoList;
    }

    public void setPagoVentaCreditoList(List<PagoVentaCredito> pagoVentaCreditoList) {
        this.pagoVentaCreditoList = pagoVentaCreditoList;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Empleado getEmpleado1() {
        return empleado1;
    }

    public void setEmpleado1(Empleado empleado1) {
        this.empleado1 = empleado1;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    @XmlTransient
    public List<NotaCredito> getNotaCreditoList() {
        return notaCreditoList;
    }

    public void setNotaCreditoList(List<NotaCredito> notaCreditoList) {
        this.notaCreditoList = notaCreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
