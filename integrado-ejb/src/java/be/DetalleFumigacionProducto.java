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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "detalle_fumigacion_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFumigacionProducto.findAll", query = "SELECT d FROM DetalleFumigacionProducto d"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByIdDetalleFumigacionProducto", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.idDetalleFumigacionProducto = :idDetalleFumigacionProducto"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByCantidad", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByUtilizo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.utilizo = :utilizo"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByQuedo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.quedo = :quedo"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByFechaRegistro", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleFumigacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_fumigacion_producto")
    private Integer idDetalleFumigacionProducto;
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
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "id_contrato_fumigacion", referencedColumnName = "id_contrato_fumigacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ContratoFumigacion contratoFumigacion;

    public DetalleFumigacionProducto() {
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto, int cantidad, BigDecimal utilizo, BigDecimal quedo, int estadoExistencia) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
        this.cantidad = cantidad;
        this.utilizo = utilizo;
        this.quedo = quedo;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdDetalleFumigacionProducto() {
        return idDetalleFumigacionProducto;
    }

    public void setIdDetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
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

    public ContratoFumigacion getContratoFumigacion() {
        return contratoFumigacion;
    }

    public void setContratoFumigacion(ContratoFumigacion contratoFumigacion) {
        this.contratoFumigacion = contratoFumigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFumigacionProducto != null ? idDetalleFumigacionProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFumigacionProducto)) {
            return false;
        }
        DetalleFumigacionProducto other = (DetalleFumigacionProducto) object;
        if ((this.idDetalleFumigacionProducto == null && other.idDetalleFumigacionProducto != null) || (this.idDetalleFumigacionProducto != null && !this.idDetalleFumigacionProducto.equals(other.idDetalleFumigacionProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFumigacionProducto[ idDetalleFumigacionProducto=" + idDetalleFumigacionProducto + " ]";
    }
    
}
