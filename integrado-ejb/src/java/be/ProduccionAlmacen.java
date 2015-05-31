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
@Table(name = "produccion_almacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduccionAlmacen.findAll", query = "SELECT p FROM ProduccionAlmacen p"),
    @NamedQuery(name = "ProduccionAlmacen.findByIdProduccionAlmacen", query = "SELECT p FROM ProduccionAlmacen p WHERE p.idProduccionAlmacen = :idProduccionAlmacen"),
    @NamedQuery(name = "ProduccionAlmacen.findByCantidadProductoTerminado", query = "SELECT p FROM ProduccionAlmacen p WHERE p.cantidadProductoTerminado = :cantidadProductoTerminado"),
    @NamedQuery(name = "ProduccionAlmacen.findByDescripcion", query = "SELECT p FROM ProduccionAlmacen p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ProduccionAlmacen.findByEstadoExistencia", query = "SELECT p FROM ProduccionAlmacen p WHERE p.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "ProduccionAlmacen.findByFechaRegistro", query = "SELECT p FROM ProduccionAlmacen p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ProduccionAlmacen.findByFechaModificacion", query = "SELECT p FROM ProduccionAlmacen p WHERE p.fechaModificacion = :fechaModificacion")})
public class ProduccionAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produccion_almacen")
    private Integer idProduccionAlmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_producto_terminado")
    private int cantidadProductoTerminado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 350)
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
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;
    @JoinColumn(name = "id_tienda_origen", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_formulacion", referencedColumnName = "id_formulacion")
    @ManyToOne(fetch = FetchType.EAGER)
    private Formulacion formulacion;

    public ProduccionAlmacen() {
    }

    public ProduccionAlmacen(Integer idProduccionAlmacen) {
        this.idProduccionAlmacen = idProduccionAlmacen;
    }

    public ProduccionAlmacen(Integer idProduccionAlmacen, int cantidadProductoTerminado, String descripcion, int estadoExistencia) {
        this.idProduccionAlmacen = idProduccionAlmacen;
        this.cantidadProductoTerminado = cantidadProductoTerminado;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdProduccionAlmacen() {
        return idProduccionAlmacen;
    }

    public void setIdProduccionAlmacen(Integer idProduccionAlmacen) {
        this.idProduccionAlmacen = idProduccionAlmacen;
    }

    public int getCantidadProductoTerminado() {
        return cantidadProductoTerminado;
    }

    public void setCantidadProductoTerminado(int cantidadProductoTerminado) {
        this.cantidadProductoTerminado = cantidadProductoTerminado;
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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Formulacion getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(Formulacion formulacion) {
        this.formulacion = formulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccionAlmacen != null ? idProduccionAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionAlmacen)) {
            return false;
        }
        ProduccionAlmacen other = (ProduccionAlmacen) object;
        if ((this.idProduccionAlmacen == null && other.idProduccionAlmacen != null) || (this.idProduccionAlmacen != null && !this.idProduccionAlmacen.equals(other.idProduccionAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ProduccionAlmacen[ idProduccionAlmacen=" + idProduccionAlmacen + " ]";
    }
    
}
