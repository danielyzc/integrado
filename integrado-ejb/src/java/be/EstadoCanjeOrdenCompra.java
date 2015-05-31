/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "estado_canje_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findAll", query = "SELECT e FROM EstadoCanjeOrdenCompra e"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByIdEstadoCanjeOrdenCompra", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.idEstadoCanjeOrdenCompra = :idEstadoCanjeOrdenCompra"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByNombre", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByDescripcion", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByFechaRegistro", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByEstadoExistencia", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoCanjeOrdenCompra.findByFechaModificacion", query = "SELECT e FROM EstadoCanjeOrdenCompra e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoCanjeOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_canje_orden_compra")
    private Integer idEstadoCanjeOrdenCompra;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 170)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(mappedBy = "estadoCanjeOrdenCompra", fetch = FetchType.EAGER)
    private List<CanjeOrdenCompra> canjeOrdenCompraList;

    public EstadoCanjeOrdenCompra() {
    }

    public EstadoCanjeOrdenCompra(Integer idEstadoCanjeOrdenCompra) {
        this.idEstadoCanjeOrdenCompra = idEstadoCanjeOrdenCompra;
    }

    public EstadoCanjeOrdenCompra(Integer idEstadoCanjeOrdenCompra, int estadoExistencia) {
        this.idEstadoCanjeOrdenCompra = idEstadoCanjeOrdenCompra;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoCanjeOrdenCompra() {
        return idEstadoCanjeOrdenCompra;
    }

    public void setIdEstadoCanjeOrdenCompra(Integer idEstadoCanjeOrdenCompra) {
        this.idEstadoCanjeOrdenCompra = idEstadoCanjeOrdenCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idEstadoCanjeOrdenCompra != null ? idEstadoCanjeOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCanjeOrdenCompra)) {
            return false;
        }
        EstadoCanjeOrdenCompra other = (EstadoCanjeOrdenCompra) object;
        if ((this.idEstadoCanjeOrdenCompra == null && other.idEstadoCanjeOrdenCompra != null) || (this.idEstadoCanjeOrdenCompra != null && !this.idEstadoCanjeOrdenCompra.equals(other.idEstadoCanjeOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoCanjeOrdenCompra[ idEstadoCanjeOrdenCompra=" + idEstadoCanjeOrdenCompra + " ]";
    }
    
}
