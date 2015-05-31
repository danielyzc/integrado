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
@Table(name = "unidad_transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadTransporte.findAll", query = "SELECT u FROM UnidadTransporte u"),
    @NamedQuery(name = "UnidadTransporte.findByIdUnidadTransporte", query = "SELECT u FROM UnidadTransporte u WHERE u.idUnidadTransporte = :idUnidadTransporte"),
    @NamedQuery(name = "UnidadTransporte.findByMarca", query = "SELECT u FROM UnidadTransporte u WHERE u.marca = :marca"),
    @NamedQuery(name = "UnidadTransporte.findByNumeroPlaca", query = "SELECT u FROM UnidadTransporte u WHERE u.numeroPlaca = :numeroPlaca"),
    @NamedQuery(name = "UnidadTransporte.findByNumeroConstanciaInscripcion", query = "SELECT u FROM UnidadTransporte u WHERE u.numeroConstanciaInscripcion = :numeroConstanciaInscripcion"),
    @NamedQuery(name = "UnidadTransporte.findByObservaciones", query = "SELECT u FROM UnidadTransporte u WHERE u.observaciones = :observaciones"),
    @NamedQuery(name = "UnidadTransporte.findByEstadoExistencia", query = "SELECT u FROM UnidadTransporte u WHERE u.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "UnidadTransporte.findByFechaRegistro", query = "SELECT u FROM UnidadTransporte u WHERE u.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "UnidadTransporte.findByFechaModificacion", query = "SELECT u FROM UnidadTransporte u WHERE u.fechaModificacion = :fechaModificacion")})
public class UnidadTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad_transporte")
    private Integer idUnidadTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "numero_placa")
    private String numeroPlaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "numero_constancia_inscripcion")
    private String numeroConstanciaInscripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "observaciones")
    private String observaciones;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadTransporte", fetch = FetchType.EAGER)
    private List<GuiaRemicion> guiaRemicionList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;

    public UnidadTransporte() {
    }

    public UnidadTransporte(Integer idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public UnidadTransporte(Integer idUnidadTransporte, String marca, String numeroPlaca, String numeroConstanciaInscripcion, String observaciones, int estadoExistencia) {
        this.idUnidadTransporte = idUnidadTransporte;
        this.marca = marca;
        this.numeroPlaca = numeroPlaca;
        this.numeroConstanciaInscripcion = numeroConstanciaInscripcion;
        this.observaciones = observaciones;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(Integer idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroConstanciaInscripcion() {
        return numeroConstanciaInscripcion;
    }

    public void setNumeroConstanciaInscripcion(String numeroConstanciaInscripcion) {
        this.numeroConstanciaInscripcion = numeroConstanciaInscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
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
        hash += (idUnidadTransporte != null ? idUnidadTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadTransporte)) {
            return false;
        }
        UnidadTransporte other = (UnidadTransporte) object;
        if ((this.idUnidadTransporte == null && other.idUnidadTransporte != null) || (this.idUnidadTransporte != null && !this.idUnidadTransporte.equals(other.idUnidadTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.UnidadTransporte[ idUnidadTransporte=" + idUnidadTransporte + " ]";
    }
    
}
