/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "detalle_servicio_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServicioProducto.findAll", query = "SELECT d FROM DetalleServicioProducto d"),
    @NamedQuery(name = "DetalleServicioProducto.findByIdServicio", query = "SELECT d FROM DetalleServicioProducto d WHERE d.detalleServicioProductoPK.idServicio = :idServicio"),
    @NamedQuery(name = "DetalleServicioProducto.findByIdProducto", query = "SELECT d FROM DetalleServicioProducto d WHERE d.detalleServicioProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleServicioProducto.findByCantidad", query = "SELECT d FROM DetalleServicioProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleServicioProducto.findByUtilizo", query = "SELECT d FROM DetalleServicioProducto d WHERE d.utilizo = :utilizo"),
    @NamedQuery(name = "DetalleServicioProducto.findByQuedo", query = "SELECT d FROM DetalleServicioProducto d WHERE d.quedo = :quedo"),
    @NamedQuery(name = "DetalleServicioProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleServicioProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleServicioProducto.findByFechaRegistro", query = "SELECT d FROM DetalleServicioProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleServicioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleServicioProductoPK detalleServicioProductoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "utilizo")
    private BigDecimal utilizo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quedo")
    private BigDecimal quedo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Servicio servicio;

    public DetalleServicioProducto() {
    }

    public DetalleServicioProducto(DetalleServicioProductoPK detalleServicioProductoPK) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
    }

    public DetalleServicioProducto(DetalleServicioProductoPK detalleServicioProductoPK, int cantidad, BigDecimal utilizo, BigDecimal quedo, int estadoExistencia) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
        this.cantidad = cantidad;
        this.utilizo = utilizo;
        this.quedo = quedo;
        this.estadoExistencia = estadoExistencia;
    }

    public DetalleServicioProducto(int idServicio, int idProducto) {
        this.detalleServicioProductoPK = new DetalleServicioProductoPK(idServicio, idProducto);
    }

    public DetalleServicioProductoPK getDetalleServicioProductoPK() {
        return detalleServicioProductoPK;
    }

    public void setDetalleServicioProductoPK(DetalleServicioProductoPK detalleServicioProductoPK) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getUtilizo() {
        return utilizo;
    }

    public void setUtilizo(BigDecimal utilizo) {
        this.utilizo = utilizo;
    }

    public BigDecimal getQuedo() {
        return quedo;
    }

    public void setQuedo(BigDecimal quedo) {
        this.quedo = quedo;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleServicioProductoPK != null ? detalleServicioProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServicioProducto)) {
            return false;
        }
        DetalleServicioProducto other = (DetalleServicioProducto) object;
        if ((this.detalleServicioProductoPK == null && other.detalleServicioProductoPK != null) || (this.detalleServicioProductoPK != null && !this.detalleServicioProductoPK.equals(other.detalleServicioProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleServicioProducto[ detalleServicioProductoPK=" + detalleServicioProductoPK + " ]";
    }
    
}
