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
@Table(name = "tipo_cuenta_contable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuentaContable.findAll", query = "SELECT t FROM TipoCuentaContable t"),
    @NamedQuery(name = "TipoCuentaContable.findByIdTipoCuentaContable", query = "SELECT t FROM TipoCuentaContable t WHERE t.idTipoCuentaContable = :idTipoCuentaContable"),
    @NamedQuery(name = "TipoCuentaContable.findByNombreTipoCuentaContable", query = "SELECT t FROM TipoCuentaContable t WHERE t.nombreTipoCuentaContable = :nombreTipoCuentaContable"),
    @NamedQuery(name = "TipoCuentaContable.findByDescripcion", query = "SELECT t FROM TipoCuentaContable t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoCuentaContable.findByEstadoExistencia", query = "SELECT t FROM TipoCuentaContable t WHERE t.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "TipoCuentaContable.findByFechaRegistro", query = "SELECT t FROM TipoCuentaContable t WHERE t.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "TipoCuentaContable.findByFechaModificacion", query = "SELECT t FROM TipoCuentaContable t WHERE t.fechaModificacion = :fechaModificacion")})
public class TipoCuentaContable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cuenta_contable")
    private Integer idTipoCuentaContable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "nombre_tipo_cuenta_contable")
    private String nombreTipoCuentaContable;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCuentaContable", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public TipoCuentaContable() {
    }

    public TipoCuentaContable(Integer idTipoCuentaContable) {
        this.idTipoCuentaContable = idTipoCuentaContable;
    }

    public TipoCuentaContable(Integer idTipoCuentaContable, String nombreTipoCuentaContable, String descripcion, int estadoExistencia) {
        this.idTipoCuentaContable = idTipoCuentaContable;
        this.nombreTipoCuentaContable = nombreTipoCuentaContable;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdTipoCuentaContable() {
        return idTipoCuentaContable;
    }

    public void setIdTipoCuentaContable(Integer idTipoCuentaContable) {
        this.idTipoCuentaContable = idTipoCuentaContable;
    }

    public String getNombreTipoCuentaContable() {
        return nombreTipoCuentaContable;
    }

    public void setNombreTipoCuentaContable(String nombreTipoCuentaContable) {
        this.nombreTipoCuentaContable = nombreTipoCuentaContable;
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
        hash += (idTipoCuentaContable != null ? idTipoCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaContable)) {
            return false;
        }
        TipoCuentaContable other = (TipoCuentaContable) object;
        if ((this.idTipoCuentaContable == null && other.idTipoCuentaContable != null) || (this.idTipoCuentaContable != null && !this.idTipoCuentaContable.equals(other.idTipoCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoCuentaContable[ idTipoCuentaContable=" + idTipoCuentaContable + " ]";
    }
    
}
