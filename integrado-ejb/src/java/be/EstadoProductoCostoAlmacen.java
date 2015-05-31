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
@Table(name = "estado_producto_costo_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findAll", query = "SELECT e FROM EstadoProductoCostoAlmacen e"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByIdEstadoProductoCostoAlmacen", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.idEstadoProductoCostoAlmacen = :idEstadoProductoCostoAlmacen"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByNombre", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByDescripcion", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByEstadoExistencia", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByFechaRegistro", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByFechaModificacion", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoProductoCostoAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_producto_costo_almacen")
    private Integer idEstadoProductoCostoAlmacen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
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
    @OneToMany(mappedBy = "estadoProductoCostoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @OneToMany(mappedBy = "estadoProductoCostoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;

    public EstadoProductoCostoAlmacen() {
    }

    public EstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
    }

    public EstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen, String nombre, String descripcion, int estadoExistencia) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoProductoCostoAlmacen() {
        return idEstadoProductoCostoAlmacen;
    }

    public void setIdEstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
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
    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
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
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProductoCostoAlmacen != null ? idEstadoProductoCostoAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProductoCostoAlmacen)) {
            return false;
        }
        EstadoProductoCostoAlmacen other = (EstadoProductoCostoAlmacen) object;
        if ((this.idEstadoProductoCostoAlmacen == null && other.idEstadoProductoCostoAlmacen != null) || (this.idEstadoProductoCostoAlmacen != null && !this.idEstadoProductoCostoAlmacen.equals(other.idEstadoProductoCostoAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoProductoCostoAlmacen[ idEstadoProductoCostoAlmacen=" + idEstadoProductoCostoAlmacen + " ]";
    }
    
}
