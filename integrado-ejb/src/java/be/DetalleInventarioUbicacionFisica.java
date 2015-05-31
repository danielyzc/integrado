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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "detalle_inventario_ubicacion_fisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findAll", query = "SELECT d FROM DetalleInventarioUbicacionFisica d"),
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findByIdDetalleInventarioUbicacionFisica", query = "SELECT d FROM DetalleInventarioUbicacionFisica d WHERE d.idDetalleInventarioUbicacionFisica = :idDetalleInventarioUbicacionFisica"),
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findByEstadoExistencia", query = "SELECT d FROM DetalleInventarioUbicacionFisica d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findByFechaRegistro", query = "SELECT d FROM DetalleInventarioUbicacionFisica d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleInventarioUbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_inventario_ubicacion_fisica")
    private Integer idDetalleInventarioUbicacionFisica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleInventarioUbicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList;
    @JoinColumn(name = "id_ubicacion_fisica", referencedColumnName = "id_ubicacion_fisica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "id_inventario_fisico", referencedColumnName = "id_inventario_fisico")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InventarioFisico inventarioFisico;

    public DetalleInventarioUbicacionFisica() {
    }

    public DetalleInventarioUbicacionFisica(Integer idDetalleInventarioUbicacionFisica) {
        this.idDetalleInventarioUbicacionFisica = idDetalleInventarioUbicacionFisica;
    }

    public DetalleInventarioUbicacionFisica(Integer idDetalleInventarioUbicacionFisica, int estadoExistencia) {
        this.idDetalleInventarioUbicacionFisica = idDetalleInventarioUbicacionFisica;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdDetalleInventarioUbicacionFisica() {
        return idDetalleInventarioUbicacionFisica;
    }

    public void setIdDetalleInventarioUbicacionFisica(Integer idDetalleInventarioUbicacionFisica) {
        this.idDetalleInventarioUbicacionFisica = idDetalleInventarioUbicacionFisica;
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

    @XmlTransient
    public List<DetalleUbicacionFisicaProducto> getDetalleUbicacionFisicaProductoList() {
        return detalleUbicacionFisicaProductoList;
    }

    public void setDetalleUbicacionFisicaProductoList(List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList) {
        this.detalleUbicacionFisicaProductoList = detalleUbicacionFisicaProductoList;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public InventarioFisico getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(InventarioFisico inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleInventarioUbicacionFisica != null ? idDetalleInventarioUbicacionFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleInventarioUbicacionFisica)) {
            return false;
        }
        DetalleInventarioUbicacionFisica other = (DetalleInventarioUbicacionFisica) object;
        if ((this.idDetalleInventarioUbicacionFisica == null && other.idDetalleInventarioUbicacionFisica != null) || (this.idDetalleInventarioUbicacionFisica != null && !this.idDetalleInventarioUbicacionFisica.equals(other.idDetalleInventarioUbicacionFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleInventarioUbicacionFisica[ idDetalleInventarioUbicacionFisica=" + idDetalleInventarioUbicacionFisica + " ]";
    }
    
}