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
@Table(name = "sub_elemento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubElemento.findAll", query = "SELECT s FROM SubElemento s"),
    @NamedQuery(name = "SubElemento.findByIdSubElemento", query = "SELECT s FROM SubElemento s WHERE s.idSubElemento = :idSubElemento"),
    @NamedQuery(name = "SubElemento.findByNombreSubElemento", query = "SELECT s FROM SubElemento s WHERE s.nombreSubElemento = :nombreSubElemento"),
    @NamedQuery(name = "SubElemento.findByDescripcion", query = "SELECT s FROM SubElemento s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SubElemento.findByEstadoExistencia", query = "SELECT s FROM SubElemento s WHERE s.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "SubElemento.findByFechaRegistro", query = "SELECT s FROM SubElemento s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "SubElemento.findByFechaModificacion", query = "SELECT s FROM SubElemento s WHERE s.fechaModificacion = :fechaModificacion")})
public class SubElemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sub_elemento")
    private Integer idSubElemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "nombre_sub_elemento")
    private String nombreSubElemento;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subElemento", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public SubElemento() {
    }

    public SubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public SubElemento(Integer idSubElemento, String nombreSubElemento, String descripcion, int estadoExistencia) {
        this.idSubElemento = idSubElemento;
        this.nombreSubElemento = nombreSubElemento;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdSubElemento() {
        return idSubElemento;
    }

    public void setIdSubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public String getNombreSubElemento() {
        return nombreSubElemento;
    }

    public void setNombreSubElemento(String nombreSubElemento) {
        this.nombreSubElemento = nombreSubElemento;
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
    public List<CuentaContable> getCuentaContableList() {
        return cuentaContableList;
    }

    public void setCuentaContableList(List<CuentaContable> cuentaContableList) {
        this.cuentaContableList = cuentaContableList;
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
        hash += (idSubElemento != null ? idSubElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubElemento)) {
            return false;
        }
        SubElemento other = (SubElemento) object;
        if ((this.idSubElemento == null && other.idSubElemento != null) || (this.idSubElemento != null && !this.idSubElemento.equals(other.idSubElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SubElemento[ idSubElemento=" + idSubElemento + " ]";
    }
    
}
