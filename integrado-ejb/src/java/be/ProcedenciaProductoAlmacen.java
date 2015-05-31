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
@Table(name = "procedencia_producto_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findAll", query = "SELECT p FROM ProcedenciaProductoAlmacen p"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByIdProcedenciaProductoAlmacen", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.idProcedenciaProductoAlmacen = :idProcedenciaProductoAlmacen"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByNombre", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByDescripcion", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByEstadoExistencia", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByFechaRegistro", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByFechaModificacion", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.fechaModificacion = :fechaModificacion")})
public class ProcedenciaProductoAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_procedencia_producto_almacen")
    private Integer idProcedenciaProductoAlmacen;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public ProcedenciaProductoAlmacen() {
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen, String nombre, String descripcion, int estadoExistencia) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdProcedenciaProductoAlmacen() {
        return idProcedenciaProductoAlmacen;
    }

    public void setIdProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
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

    @XmlTransient
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
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
        hash += (idProcedenciaProductoAlmacen != null ? idProcedenciaProductoAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedenciaProductoAlmacen)) {
            return false;
        }
        ProcedenciaProductoAlmacen other = (ProcedenciaProductoAlmacen) object;
        if ((this.idProcedenciaProductoAlmacen == null && other.idProcedenciaProductoAlmacen != null) || (this.idProcedenciaProductoAlmacen != null && !this.idProcedenciaProductoAlmacen.equals(other.idProcedenciaProductoAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ProcedenciaProductoAlmacen[ idProcedenciaProductoAlmacen=" + idProcedenciaProductoAlmacen + " ]";
    }
    
}
