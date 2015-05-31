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
@Table(name = "formulacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulacion.findAll", query = "SELECT f FROM Formulacion f"),
    @NamedQuery(name = "Formulacion.findByIdFormulacion", query = "SELECT f FROM Formulacion f WHERE f.idFormulacion = :idFormulacion"),
    @NamedQuery(name = "Formulacion.findByPalabraClave", query = "SELECT f FROM Formulacion f WHERE f.palabraClave = :palabraClave"),
    @NamedQuery(name = "Formulacion.findByDescripcion", query = "SELECT f FROM Formulacion f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Formulacion.findByEstadoExistencia", query = "SELECT f FROM Formulacion f WHERE f.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "Formulacion.findByFechaRegistro", query = "SELECT f FROM Formulacion f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Formulacion.findByFechaModificacion", query = "SELECT f FROM Formulacion f WHERE f.fechaModificacion = :fechaModificacion")})
public class Formulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formulacion")
    private Integer idFormulacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "palabra_clave")
    private String palabraClave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Basic(optional = false)
    @NotNull
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
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulacion", fetch = FetchType.EAGER)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList;
    @OneToMany(mappedBy = "formulacion", fetch = FetchType.EAGER)
    private List<ProduccionAlmacen> produccionAlmacenList;

    public Formulacion() {
    }

    public Formulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public Formulacion(Integer idFormulacion, String palabraClave, String descripcion, int estadoExistencia, Date fechaRegistro) {
        this.idFormulacion = idFormulacion;
        this.palabraClave = palabraClave;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdFormulacion() {
        return idFormulacion;
    }

    public void setIdFormulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @XmlTransient
    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList() {
        return detalleFormulacionInsumosList;
    }

    public void setDetalleFormulacionInsumosList(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList) {
        this.detalleFormulacionInsumosList = detalleFormulacionInsumosList;
    }

    @XmlTransient
    public List<ProduccionAlmacen> getProduccionAlmacenList() {
        return produccionAlmacenList;
    }

    public void setProduccionAlmacenList(List<ProduccionAlmacen> produccionAlmacenList) {
        this.produccionAlmacenList = produccionAlmacenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulacion != null ? idFormulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulacion)) {
            return false;
        }
        Formulacion other = (Formulacion) object;
        if ((this.idFormulacion == null && other.idFormulacion != null) || (this.idFormulacion != null && !this.idFormulacion.equals(other.idFormulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Formulacion[ idFormulacion=" + idFormulacion + " ]";
    }
    
}
