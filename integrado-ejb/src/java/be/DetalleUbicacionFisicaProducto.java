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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "detalle_ubicacion_fisica_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findAll", query = "SELECT d FROM DetalleUbicacionFisicaProducto d"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByIdDetalleUbicacionFisicaProducto", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.idDetalleUbicacionFisicaProducto = :idDetalleUbicacionFisicaProducto"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByCantidad", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByEstadoExistencia", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByFechaRegistro", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.fechaRegistro = :fechaRegistro")})
public class DetalleUbicacionFisicaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_ubicacion_fisica_producto")
    private Integer idDetalleUbicacionFisicaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
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
    @JoinColumn(name = "id_detalle_inventario_ubicacion_fisica", referencedColumnName = "id_detalle_inventario_ubicacion_fisica")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica;

    public DetalleUbicacionFisicaProducto() {
    }

    public DetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
    }

    public DetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto, int cantidad, int estadoExistencia) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
        this.cantidad = cantidad;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdDetalleUbicacionFisicaProducto() {
        return idDetalleUbicacionFisicaProducto;
    }

    public void setIdDetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public DetalleInventarioUbicacionFisica getDetalleInventarioUbicacionFisica() {
        return detalleInventarioUbicacionFisica;
    }

    public void setDetalleInventarioUbicacionFisica(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica) {
        this.detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleUbicacionFisicaProducto != null ? idDetalleUbicacionFisicaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleUbicacionFisicaProducto)) {
            return false;
        }
        DetalleUbicacionFisicaProducto other = (DetalleUbicacionFisicaProducto) object;
        if ((this.idDetalleUbicacionFisicaProducto == null && other.idDetalleUbicacionFisicaProducto != null) || (this.idDetalleUbicacionFisicaProducto != null && !this.idDetalleUbicacionFisicaProducto.equals(other.idDetalleUbicacionFisicaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleUbicacionFisicaProducto[ idDetalleUbicacionFisicaProducto=" + idDetalleUbicacionFisicaProducto + " ]";
    }
    
}
