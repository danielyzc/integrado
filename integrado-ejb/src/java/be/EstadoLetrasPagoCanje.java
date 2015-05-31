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
@Table(name = "estado_letras_pago_canje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoLetrasPagoCanje.findAll", query = "SELECT e FROM EstadoLetrasPagoCanje e"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByIdEstadoLetrasPagoCanje", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.idEstadoLetrasPagoCanje = :idEstadoLetrasPagoCanje"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByNombre", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByDescripcion", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByEstadoExistencia", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByFechaRegistro", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByFechaModificacion", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoLetrasPagoCanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_letras_pago_canje")
    private Integer idEstadoLetrasPagoCanje;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 170)
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
    @OneToMany(mappedBy = "estadoLetrasPagoCanje", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList;

    public EstadoLetrasPagoCanje() {
    }

    public EstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
    }

    public EstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje, int estadoExistencia) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoLetrasPagoCanje() {
        return idEstadoLetrasPagoCanje;
    }

    public void setIdEstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
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
    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLetrasPagoCanje != null ? idEstadoLetrasPagoCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLetrasPagoCanje)) {
            return false;
        }
        EstadoLetrasPagoCanje other = (EstadoLetrasPagoCanje) object;
        if ((this.idEstadoLetrasPagoCanje == null && other.idEstadoLetrasPagoCanje != null) || (this.idEstadoLetrasPagoCanje != null && !this.idEstadoLetrasPagoCanje.equals(other.idEstadoLetrasPagoCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoLetrasPagoCanje[ idEstadoLetrasPagoCanje=" + idEstadoLetrasPagoCanje + " ]";
    }
    
}
