/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tipo_plaga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPlaga.findAll", query = "SELECT t FROM TipoPlaga t"),
    @NamedQuery(name = "TipoPlaga.findByIdTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.idTipoPlaga = :idTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByNombreTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.nombreTipoPlaga = :nombreTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByDescripcion", query = "SELECT t FROM TipoPlaga t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoPlaga.findByEstadoExistencia", query = "SELECT t FROM TipoPlaga t WHERE t.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "TipoPlaga.findByFechaRegistro", query = "SELECT t FROM TipoPlaga t WHERE t.fechaRegistro = :fechaRegistro")})
public class TipoPlaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_plaga")
    private Integer idTipoPlaga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "nombre_tipo_plaga")
    private String nombreTipoPlaga;
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

    public TipoPlaga() {
    }

    public TipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public TipoPlaga(Integer idTipoPlaga, String nombreTipoPlaga, String descripcion, int estadoExistencia) {
        this.idTipoPlaga = idTipoPlaga;
        this.nombreTipoPlaga = nombreTipoPlaga;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdTipoPlaga() {
        return idTipoPlaga;
    }

    public void setIdTipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public String getNombreTipoPlaga() {
        return nombreTipoPlaga;
    }

    public void setNombreTipoPlaga(String nombreTipoPlaga) {
        this.nombreTipoPlaga = nombreTipoPlaga;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPlaga != null ? idTipoPlaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlaga)) {
            return false;
        }
        TipoPlaga other = (TipoPlaga) object;
        if ((this.idTipoPlaga == null && other.idTipoPlaga != null) || (this.idTipoPlaga != null && !this.idTipoPlaga.equals(other.idTipoPlaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoPlaga[ idTipoPlaga=" + idTipoPlaga + " ]";
    }
    
}
