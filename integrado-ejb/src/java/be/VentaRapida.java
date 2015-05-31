/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "venta_rapida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaRapida.findAll", query = "SELECT v FROM VentaRapida v"),
    @NamedQuery(name = "VentaRapida.findByIdVentaRapida", query = "SELECT v FROM VentaRapida v WHERE v.idVentaRapida = :idVentaRapida"),
    @NamedQuery(name = "VentaRapida.findByFechaVenta", query = "SELECT v FROM VentaRapida v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "VentaRapida.findByEstadoExistencia", query = "SELECT v FROM VentaRapida v WHERE v.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "VentaRapida.findByFechaRegistro", query = "SELECT v FROM VentaRapida v WHERE v.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "VentaRapida.findByFechaModificacion", query = "SELECT v FROM VentaRapida v WHERE v.fechaModificacion = :fechaModificacion")})
public class VentaRapida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta_rapida")
    private Integer idVentaRapida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaRapida", fetch = FetchType.EAGER)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;

    public VentaRapida() {
    }

    public VentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public VentaRapida(Integer idVentaRapida, Date fechaVenta, int estadoExistencia) {
        this.idVentaRapida = idVentaRapida;
        this.fechaVenta = fechaVenta;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdVentaRapida() {
        return idVentaRapida;
    }

    public void setIdVentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    @XmlTransient
    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentaRapida != null ? idVentaRapida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaRapida)) {
            return false;
        }
        VentaRapida other = (VentaRapida) object;
        if ((this.idVentaRapida == null && other.idVentaRapida != null) || (this.idVentaRapida != null && !this.idVentaRapida.equals(other.idVentaRapida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.VentaRapida[ idVentaRapida=" + idVentaRapida + " ]";
    }
    
}
