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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cuenta_contable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaContable.findAll", query = "SELECT c FROM CuentaContable c"),
    @NamedQuery(name = "CuentaContable.findByIdCuentaContable", query = "SELECT c FROM CuentaContable c WHERE c.idCuentaContable = :idCuentaContable"),
    @NamedQuery(name = "CuentaContable.findByNumero", query = "SELECT c FROM CuentaContable c WHERE c.numero = :numero"),
    @NamedQuery(name = "CuentaContable.findByNombreCuentaContable", query = "SELECT c FROM CuentaContable c WHERE c.nombreCuentaContable = :nombreCuentaContable"),
    @NamedQuery(name = "CuentaContable.findByDescripcion", query = "SELECT c FROM CuentaContable c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CuentaContable.findByEstadoExistencia", query = "SELECT c FROM CuentaContable c WHERE c.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "CuentaContable.findByFechaRegistro", query = "SELECT c FROM CuentaContable c WHERE c.fechaRegistro = :fechaRegistro")})
public class CuentaContable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_contable")
    private Integer idCuentaContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "nombre_cuenta_contable")
    private String nombreCuentaContable;
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
    @JoinColumn(name = "id_sub_elemento", referencedColumnName = "id_sub_elemento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubElemento subElemento;
    @JoinColumn(name = "id_tipo_elemento", referencedColumnName = "id_tipo_elemento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoElemento tipoElemento;
    @JoinColumn(name = "id_tipo_cuenta_contable", referencedColumnName = "id_tipo_cuenta_contable")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCuentaContable tipoCuentaContable;

    public CuentaContable() {
    }

    public CuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public CuentaContable(Integer idCuentaContable, int numero, String nombreCuentaContable, String descripcion, int estadoExistencia) {
        this.idCuentaContable = idCuentaContable;
        this.numero = numero;
        this.nombreCuentaContable = nombreCuentaContable;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdCuentaContable() {
        return idCuentaContable;
    }

    public void setIdCuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreCuentaContable() {
        return nombreCuentaContable;
    }

    public void setNombreCuentaContable(String nombreCuentaContable) {
        this.nombreCuentaContable = nombreCuentaContable;
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

    public SubElemento getSubElemento() {
        return subElemento;
    }

    public void setSubElemento(SubElemento subElemento) {
        this.subElemento = subElemento;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public TipoCuentaContable getTipoCuentaContable() {
        return tipoCuentaContable;
    }

    public void setTipoCuentaContable(TipoCuentaContable tipoCuentaContable) {
        this.tipoCuentaContable = tipoCuentaContable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaContable != null ? idCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaContable)) {
            return false;
        }
        CuentaContable other = (CuentaContable) object;
        if ((this.idCuentaContable == null && other.idCuentaContable != null) || (this.idCuentaContable != null && !this.idCuentaContable.equals(other.idCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.CuentaContable[ idCuentaContable=" + idCuentaContable + " ]";
    }
    
}
