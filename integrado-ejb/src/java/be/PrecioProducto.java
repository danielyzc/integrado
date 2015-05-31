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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "precio_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioProducto.findAll", query = "SELECT p FROM PrecioProducto p"),
    @NamedQuery(name = "PrecioProducto.findByIdProducto", query = "SELECT p FROM PrecioProducto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "PrecioProducto.findByFechaActualizacion", query = "SELECT p FROM PrecioProducto p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "PrecioProducto.findByPrecioProducto", query = "SELECT p FROM PrecioProducto p WHERE p.precioProducto = :precioProducto"),
    @NamedQuery(name = "PrecioProducto.findByEstadoExistencia", query = "SELECT p FROM PrecioProducto p WHERE p.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "PrecioProducto.findByFechaRegistro", query = "SELECT p FROM PrecioProducto p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "PrecioProducto.findByFechaModificacion", query = "SELECT p FROM PrecioProducto p WHERE p.fechaModificacion = :fechaModificacion")})
public class PrecioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_producto")
    private BigDecimal precioProducto;
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
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;

    public PrecioProducto() {
    }

    public PrecioProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public PrecioProducto(Integer idProducto, Date fechaActualizacion, BigDecimal precioProducto, int estadoExistencia) {
        this.idProducto = idProducto;
        this.fechaActualizacion = fechaActualizacion;
        this.precioProducto = precioProducto;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioProducto)) {
            return false;
        }
        PrecioProducto other = (PrecioProducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PrecioProducto[ idProducto=" + idProducto + " ]";
    }
    
}
