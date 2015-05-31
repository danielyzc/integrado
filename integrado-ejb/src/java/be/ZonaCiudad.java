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
@Table(name = "zona_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaCiudad.findAll", query = "SELECT z FROM ZonaCiudad z"),
    @NamedQuery(name = "ZonaCiudad.findByIdZonaCiudad", query = "SELECT z FROM ZonaCiudad z WHERE z.idZonaCiudad = :idZonaCiudad"),
    @NamedQuery(name = "ZonaCiudad.findByDescripcionZonaCiudad", query = "SELECT z FROM ZonaCiudad z WHERE z.descripcionZonaCiudad = :descripcionZonaCiudad"),
    @NamedQuery(name = "ZonaCiudad.findByFlagEstado", query = "SELECT z FROM ZonaCiudad z WHERE z.flagEstado = :flagEstado"),
    @NamedQuery(name = "ZonaCiudad.findByEstadoExistencia", query = "SELECT z FROM ZonaCiudad z WHERE z.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "ZonaCiudad.findByFechaRegistro", query = "SELECT z FROM ZonaCiudad z WHERE z.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ZonaCiudad.findByFechaModificacion", query = "SELECT z FROM ZonaCiudad z WHERE z.fechaModificacion = :fechaModificacion")})
public class ZonaCiudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zona_ciudad")
    private Integer idZonaCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion_zona_ciudad")
    private String descripcionZonaCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "flag_estado")
    private String flagEstado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaCiudad", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public ZonaCiudad() {
    }

    public ZonaCiudad(Integer idZonaCiudad) {
        this.idZonaCiudad = idZonaCiudad;
    }

    public ZonaCiudad(Integer idZonaCiudad, String descripcionZonaCiudad, String flagEstado, int estadoExistencia) {
        this.idZonaCiudad = idZonaCiudad;
        this.descripcionZonaCiudad = descripcionZonaCiudad;
        this.flagEstado = flagEstado;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdZonaCiudad() {
        return idZonaCiudad;
    }

    public void setIdZonaCiudad(Integer idZonaCiudad) {
        this.idZonaCiudad = idZonaCiudad;
    }

    public String getDescripcionZonaCiudad() {
        return descripcionZonaCiudad;
    }

    public void setDescripcionZonaCiudad(String descripcionZonaCiudad) {
        this.descripcionZonaCiudad = descripcionZonaCiudad;
    }

    public String getFlagEstado() {
        return flagEstado;
    }

    public void setFlagEstado(String flagEstado) {
        this.flagEstado = flagEstado;
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
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
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
        hash += (idZonaCiudad != null ? idZonaCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaCiudad)) {
            return false;
        }
        ZonaCiudad other = (ZonaCiudad) object;
        if ((this.idZonaCiudad == null && other.idZonaCiudad != null) || (this.idZonaCiudad != null && !this.idZonaCiudad.equals(other.idZonaCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ZonaCiudad[ idZonaCiudad=" + idZonaCiudad + " ]";
    }
    
}
