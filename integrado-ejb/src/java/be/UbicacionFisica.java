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
@Table(name = "ubicacion_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UbicacionFisica.findAll", query = "SELECT u FROM UbicacionFisica u"),
    @NamedQuery(name = "UbicacionFisica.findByIdUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.idUbicacionFisica = :idUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByNombreUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.nombreUbicacionFisica = :nombreUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByDescripcionUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.descripcionUbicacionFisica = :descripcionUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByEstadoExistencia", query = "SELECT u FROM UbicacionFisica u WHERE u.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "UbicacionFisica.findByFechaRegistro", query = "SELECT u FROM UbicacionFisica u WHERE u.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "UbicacionFisica.findByFechaModificacion", query = "SELECT u FROM UbicacionFisica u WHERE u.fechaModificacion = :fechaModificacion")})
public class UbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ubicacion_fisica")
    private Integer idUbicacionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_ubicacion_fisica")
    private String nombreUbicacionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_ubicacion_fisica")
    private String descripcionUbicacionFisica;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList;

    public UbicacionFisica() {
    }

    public UbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public UbicacionFisica(Integer idUbicacionFisica, String nombreUbicacionFisica, String descripcionUbicacionFisica, int estadoExistencia) {
        this.idUbicacionFisica = idUbicacionFisica;
        this.nombreUbicacionFisica = nombreUbicacionFisica;
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdUbicacionFisica() {
        return idUbicacionFisica;
    }

    public void setIdUbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public String getNombreUbicacionFisica() {
        return nombreUbicacionFisica;
    }

    public void setNombreUbicacionFisica(String nombreUbicacionFisica) {
        this.nombreUbicacionFisica = nombreUbicacionFisica;
    }

    public String getDescripcionUbicacionFisica() {
        return descripcionUbicacionFisica;
    }

    public void setDescripcionUbicacionFisica(String descripcionUbicacionFisica) {
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
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

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    @XmlTransient
    public List<DetalleInventarioUbicacionFisica> getDetalleInventarioUbicacionFisicaList() {
        return detalleInventarioUbicacionFisicaList;
    }

    public void setDetalleInventarioUbicacionFisicaList(List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList) {
        this.detalleInventarioUbicacionFisicaList = detalleInventarioUbicacionFisicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacionFisica != null ? idUbicacionFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionFisica)) {
            return false;
        }
        UbicacionFisica other = (UbicacionFisica) object;
        if ((this.idUbicacionFisica == null && other.idUbicacionFisica != null) || (this.idUbicacionFisica != null && !this.idUbicacionFisica.equals(other.idUbicacionFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.UbicacionFisica[ idUbicacionFisica=" + idUbicacionFisica + " ]";
    }
    
}
