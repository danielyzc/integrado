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
@Table(name = "ingreso_producto_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoProductoTienda.findAll", query = "SELECT i FROM IngresoProductoTienda i"),
    @NamedQuery(name = "IngresoProductoTienda.findByIdIngresoProductoTienda", query = "SELECT i FROM IngresoProductoTienda i WHERE i.idIngresoProductoTienda = :idIngresoProductoTienda"),
    @NamedQuery(name = "IngresoProductoTienda.findByCantidad", query = "SELECT i FROM IngresoProductoTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaIngreso", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaVencimiento", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "IngresoProductoTienda.findByMotivo", query = "SELECT i FROM IngresoProductoTienda i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "IngresoProductoTienda.findByCostoUnitario", query = "SELECT i FROM IngresoProductoTienda i WHERE i.costoUnitario = :costoUnitario"),
    @NamedQuery(name = "IngresoProductoTienda.findByEstadoExistencia", query = "SELECT i FROM IngresoProductoTienda i WHERE i.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaRegistro", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaModificacion", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaModificacion = :fechaModificacion")})
public class IngresoProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_producto_tienda")
    private Integer idIngresoProductoTienda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "motivo")
    private String motivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;
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
    @JoinColumn(name = "id_ubicacion_fisica", referencedColumnName = "id_ubicacion_fisica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public IngresoProductoTienda() {
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda, int cantidad, Date fechaIngreso, Date fechaVencimiento, String motivo, BigDecimal costoUnitario, int estadoExistencia) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.motivo = motivo;
        this.costoUnitario = costoUnitario;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdIngresoProductoTienda() {
        return idIngresoProductoTienda;
    }

    public void setIdIngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
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

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Empleado getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(Empleado empleado2) {
        this.empleado2 = empleado2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoProductoTienda != null ? idIngresoProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoProductoTienda)) {
            return false;
        }
        IngresoProductoTienda other = (IngresoProductoTienda) object;
        if ((this.idIngresoProductoTienda == null && other.idIngresoProductoTienda != null) || (this.idIngresoProductoTienda != null && !this.idIngresoProductoTienda.equals(other.idIngresoProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoProductoTienda[ idIngresoProductoTienda=" + idIngresoProductoTienda + " ]";
    }
    
}