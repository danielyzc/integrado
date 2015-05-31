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
@Table(name = "estado_igv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoIgv.findAll", query = "SELECT e FROM EstadoIgv e"),
    @NamedQuery(name = "EstadoIgv.findByIdEstadoIgv", query = "SELECT e FROM EstadoIgv e WHERE e.idEstadoIgv = :idEstadoIgv"),
    @NamedQuery(name = "EstadoIgv.findByNombreEstado", query = "SELECT e FROM EstadoIgv e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoIgv.findByDescripcion", query = "SELECT e FROM EstadoIgv e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoIgv.findByEstadoExistencia", query = "SELECT e FROM EstadoIgv e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoIgv.findByFechaRegistro", query = "SELECT e FROM EstadoIgv e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoIgv.findByFechaModificacion", query = "SELECT e FROM EstadoIgv e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoIgv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_igv")
    private Integer idEstadoIgv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_estado")
    private String nombreEstado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoIgv", fetch = FetchType.EAGER)
    private List<IgvFactura> igvFacturaList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public EstadoIgv() {
    }

    public EstadoIgv(Integer idEstadoIgv) {
        this.idEstadoIgv = idEstadoIgv;
    }

    public EstadoIgv(Integer idEstadoIgv, String nombreEstado, String descripcion, int estadoExistencia) {
        this.idEstadoIgv = idEstadoIgv;
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoIgv() {
        return idEstadoIgv;
    }

    public void setIdEstadoIgv(Integer idEstadoIgv) {
        this.idEstadoIgv = idEstadoIgv;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
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
    public List<IgvFactura> getIgvFacturaList() {
        return igvFacturaList;
    }

    public void setIgvFacturaList(List<IgvFactura> igvFacturaList) {
        this.igvFacturaList = igvFacturaList;
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
        hash += (idEstadoIgv != null ? idEstadoIgv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIgv)) {
            return false;
        }
        EstadoIgv other = (EstadoIgv) object;
        if ((this.idEstadoIgv == null && other.idEstadoIgv != null) || (this.idEstadoIgv != null && !this.idEstadoIgv.equals(other.idEstadoIgv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoIgv[ idEstadoIgv=" + idEstadoIgv + " ]";
    }
    
}
