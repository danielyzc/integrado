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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "pago_compra_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoCompraCredito.findAll", query = "SELECT p FROM PagoCompraCredito p"),
    @NamedQuery(name = "PagoCompraCredito.findByIdPagoCompraCredito", query = "SELECT p FROM PagoCompraCredito p WHERE p.idPagoCompraCredito = :idPagoCompraCredito"),
    @NamedQuery(name = "PagoCompraCredito.findByFechaIngreso", query = "SELECT p FROM PagoCompraCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoCompraCredito.findByObservaciones", query = "SELECT p FROM PagoCompraCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoCompraCredito.findByCantidad", query = "SELECT p FROM PagoCompraCredito p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PagoCompraCredito.findByEstadoExistencia", query = "SELECT p FROM PagoCompraCredito p WHERE p.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "PagoCompraCredito.findByFechaRegistro", query = "SELECT p FROM PagoCompraCredito p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "PagoCompraCredito.findByFechaModificacion", query = "SELECT p FROM PagoCompraCredito p WHERE p.fechaModificacion = :fechaModificacion")})
public class PagoCompraCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago_compra_credito")
    private Integer idPagoCompraCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "observaciones")
    private String observaciones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenCompra ordenCompra;

    public PagoCompraCredito() {
    }

    public PagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
    }

    public PagoCompraCredito(Integer idPagoCompraCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad, int estadoExistencia) {
        this.idPagoCompraCredito = idPagoCompraCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdPagoCompraCredito() {
        return idPagoCompraCredito;
    }

    public void setIdPagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
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

    public Empleado getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(Empleado empleado2) {
        this.empleado2 = empleado2;
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
        hash += (idPagoCompraCredito != null ? idPagoCompraCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoCompraCredito)) {
            return false;
        }
        PagoCompraCredito other = (PagoCompraCredito) object;
        if ((this.idPagoCompraCredito == null && other.idPagoCompraCredito != null) || (this.idPagoCompraCredito != null && !this.idPagoCompraCredito.equals(other.idPagoCompraCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoCompraCredito[ idPagoCompraCredito=" + idPagoCompraCredito + " ]";
    }
    
}
