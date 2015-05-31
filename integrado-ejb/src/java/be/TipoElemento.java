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
@Table(name = "tipo_elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoElemento.findAll", query = "SELECT t FROM TipoElemento t"),
    @NamedQuery(name = "TipoElemento.findByIdTipoElemento", query = "SELECT t FROM TipoElemento t WHERE t.idTipoElemento = :idTipoElemento"),
    @NamedQuery(name = "TipoElemento.findByNombreTipoElemento", query = "SELECT t FROM TipoElemento t WHERE t.nombreTipoElemento = :nombreTipoElemento"),
    @NamedQuery(name = "TipoElemento.findByDescripcion", query = "SELECT t FROM TipoElemento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoElemento.findByEstadoExistencia", query = "SELECT t FROM TipoElemento t WHERE t.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "TipoElemento.findByFechaRegistro", query = "SELECT t FROM TipoElemento t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TipoElemento.findByFechaModificacion", query = "SELECT t FROM TipoElemento t WHERE t.fechaModificacion = :fechaModificacion")})
public class TipoElemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_elemento")
    private Integer idTipoElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "nombre_tipo_elemento")
    private String nombreTipoElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoElemento", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;

    public TipoElemento() {
    }

    public TipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public TipoElemento(Integer idTipoElemento, String nombreTipoElemento, String descripcion, int estadoExistencia) {
        this.idTipoElemento = idTipoElemento;
        this.nombreTipoElemento = nombreTipoElemento;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public String getNombreTipoElemento() {
        return nombreTipoElemento;
    }

    public void setNombreTipoElemento(String nombreTipoElemento) {
        this.nombreTipoElemento = nombreTipoElemento;
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
    public List<CuentaContable> getCuentaContableList() {
        return cuentaContableList;
    }

    public void setCuentaContableList(List<CuentaContable> cuentaContableList) {
        this.cuentaContableList = cuentaContableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoElemento != null ? idTipoElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoElemento)) {
            return false;
        }
        TipoElemento other = (TipoElemento) object;
        if ((this.idTipoElemento == null && other.idTipoElemento != null) || (this.idTipoElemento != null && !this.idTipoElemento.equals(other.idTipoElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoElemento[ idTipoElemento=" + idTipoElemento + " ]";
    }
    
}
