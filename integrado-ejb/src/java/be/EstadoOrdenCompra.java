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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "estado_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoOrdenCompra.findAll", query = "SELECT e FROM EstadoOrdenCompra e"),
    @NamedQuery(name = "EstadoOrdenCompra.findByIdEstadoOrdenCompra", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.idEstadoOrdenCompra = :idEstadoOrdenCompra"),
    @NamedQuery(name = "EstadoOrdenCompra.findByNombre", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoOrdenCompra.findByDescripcion", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoOrdenCompra.findByEstadoExistencia", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoOrdenCompra.findByFechaRegistro", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoOrdenCompra.findByFechaModificacion", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_orden_compra")
    private Integer idEstadoOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOrdenCompra", fetch = FetchType.EAGER)
    private List<OrdenCompra> ordenCompraList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public EstadoOrdenCompra() {
    }

    public EstadoOrdenCompra(Integer idEstadoOrdenCompra) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
    }

    public EstadoOrdenCompra(Integer idEstadoOrdenCompra, String nombre, String descripcion, int estadoExistencia) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoOrdenCompra() {
        return idEstadoOrdenCompra;
    }

    public void setIdEstadoOrdenCompra(Integer idEstadoOrdenCompra) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
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
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrdenCompra != null ? idEstadoOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrdenCompra)) {
            return false;
        }
        EstadoOrdenCompra other = (EstadoOrdenCompra) object;
        if ((this.idEstadoOrdenCompra == null && other.idEstadoOrdenCompra != null) || (this.idEstadoOrdenCompra != null && !this.idEstadoOrdenCompra.equals(other.idEstadoOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoOrdenCompra[ idEstadoOrdenCompra=" + idEstadoOrdenCompra + " ]";
    }
    
}
