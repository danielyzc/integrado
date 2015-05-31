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
@Table(name = "material_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialProducto.findAll", query = "SELECT m FROM MaterialProducto m"),
    @NamedQuery(name = "MaterialProducto.findByIdMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.idMaterialProducto = :idMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByNombreMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.nombreMaterialProducto = :nombreMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByDescripcion", query = "SELECT m FROM MaterialProducto m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MaterialProducto.findByEstadoExistencia", query = "SELECT m FROM MaterialProducto m WHERE m.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "MaterialProducto.findByFechaRegistro", query = "SELECT m FROM MaterialProducto m WHERE m.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "MaterialProducto.findByFechaModificacion", query = "SELECT m FROM MaterialProducto m WHERE m.fechaModificacion = :fechaModificacion")})
public class MaterialProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material_producto")
    private Integer idMaterialProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_material_producto")
    private String nombreMaterialProducto;
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
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialProducto", fetch = FetchType.EAGER)
    private List<Producto> productoList;

    public MaterialProducto() {
    }

    public MaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public MaterialProducto(Integer idMaterialProducto, String nombreMaterialProducto, String descripcion, int estadoExistencia) {
        this.idMaterialProducto = idMaterialProducto;
        this.nombreMaterialProducto = nombreMaterialProducto;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdMaterialProducto() {
        return idMaterialProducto;
    }

    public void setIdMaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public String getNombreMaterialProducto() {
        return nombreMaterialProducto;
    }

    public void setNombreMaterialProducto(String nombreMaterialProducto) {
        this.nombreMaterialProducto = nombreMaterialProducto;
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
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialProducto != null ? idMaterialProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialProducto)) {
            return false;
        }
        MaterialProducto other = (MaterialProducto) object;
        if ((this.idMaterialProducto == null && other.idMaterialProducto != null) || (this.idMaterialProducto != null && !this.idMaterialProducto.equals(other.idMaterialProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MaterialProducto[ idMaterialProducto=" + idMaterialProducto + " ]";
    }
    
}
