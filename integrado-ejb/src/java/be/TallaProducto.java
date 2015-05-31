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
@Table(name = "talla_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TallaProducto.findAll", query = "SELECT t FROM TallaProducto t"),
    @NamedQuery(name = "TallaProducto.findByIdTallaProducto", query = "SELECT t FROM TallaProducto t WHERE t.idTallaProducto = :idTallaProducto"),
    @NamedQuery(name = "TallaProducto.findByNombreTallaProducto", query = "SELECT t FROM TallaProducto t WHERE t.nombreTallaProducto = :nombreTallaProducto"),
    @NamedQuery(name = "TallaProducto.findByDescripcion", query = "SELECT t FROM TallaProducto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TallaProducto.findByEstadoExistencia", query = "SELECT t FROM TallaProducto t WHERE t.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "TallaProducto.findByFechaRegistro", query = "SELECT t FROM TallaProducto t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TallaProducto.findByFechaModificacion", query = "SELECT t FROM TallaProducto t WHERE t.fechaModificacion = :fechaModificacion")})
public class TallaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_talla_producto")
    private Integer idTallaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_talla_producto")
    private String nombreTallaProducto;
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
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tallaProducto", fetch = FetchType.EAGER)
    private List<Producto> productoList;

    public TallaProducto() {
    }

    public TallaProducto(Integer idTallaProducto) {
        this.idTallaProducto = idTallaProducto;
    }

    public TallaProducto(Integer idTallaProducto, String nombreTallaProducto, String descripcion, int estadoExistencia) {
        this.idTallaProducto = idTallaProducto;
        this.nombreTallaProducto = nombreTallaProducto;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdTallaProducto() {
        return idTallaProducto;
    }

    public void setIdTallaProducto(Integer idTallaProducto) {
        this.idTallaProducto = idTallaProducto;
    }

    public String getNombreTallaProducto() {
        return nombreTallaProducto;
    }

    public void setNombreTallaProducto(String nombreTallaProducto) {
        this.nombreTallaProducto = nombreTallaProducto;
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

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTallaProducto != null ? idTallaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TallaProducto)) {
            return false;
        }
        TallaProducto other = (TallaProducto) object;
        if ((this.idTallaProducto == null && other.idTallaProducto != null) || (this.idTallaProducto != null && !this.idTallaProducto.equals(other.idTallaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TallaProducto[ idTallaProducto=" + idTallaProducto + " ]";
    }
    
}
