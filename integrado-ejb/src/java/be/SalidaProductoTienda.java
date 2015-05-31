/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
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
@Table(name = "salida_producto_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaProductoTienda.findAll", query = "SELECT s FROM SalidaProductoTienda s"),
    @NamedQuery(name = "SalidaProductoTienda.findByIdSalidaProductoTienda", query = "SELECT s FROM SalidaProductoTienda s WHERE s.idSalidaProductoTienda = :idSalidaProductoTienda"),
    @NamedQuery(name = "SalidaProductoTienda.findByCantidad", query = "SELECT s FROM SalidaProductoTienda s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SalidaProductoTienda.findByFechaSalida", query = "SELECT s FROM SalidaProductoTienda s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "SalidaProductoTienda.findByMotivo", query = "SELECT s FROM SalidaProductoTienda s WHERE s.motivo = :motivo"),
    @NamedQuery(name = "SalidaProductoTienda.findByFechaRegistro", query = "SELECT s FROM SalidaProductoTienda s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "SalidaProductoTienda.findByEstadoExistencia", query = "SELECT s FROM SalidaProductoTienda s WHERE s.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "SalidaProductoTienda.findByFechaModificacion", query = "SELECT s FROM SalidaProductoTienda s WHERE s.fechaModificacion = :fechaModificacion")})
public class SalidaProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida_producto_tienda")
    private Integer idSalidaProductoTienda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "motivo")
    private String motivo;
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
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public SalidaProductoTienda() {
    }

    public SalidaProductoTienda(Integer idSalidaProductoTienda) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
    }

    public SalidaProductoTienda(Integer idSalidaProductoTienda, int cantidad, Date fechaSalida, String motivo, int estadoExistencia) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdSalidaProductoTienda() {
        return idSalidaProductoTienda;
    }

    public void setIdSalidaProductoTienda(Integer idSalidaProductoTienda) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (idSalidaProductoTienda != null ? idSalidaProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaProductoTienda)) {
            return false;
        }
        SalidaProductoTienda other = (SalidaProductoTienda) object;
        if ((this.idSalidaProductoTienda == null && other.idSalidaProductoTienda != null) || (this.idSalidaProductoTienda != null && !this.idSalidaProductoTienda.equals(other.idSalidaProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SalidaProductoTienda[ idSalidaProductoTienda=" + idSalidaProductoTienda + " ]";
    }
    
}
