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
@Table(name = "estado_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoVenta.findAll", query = "SELECT e FROM EstadoVenta e"),
    @NamedQuery(name = "EstadoVenta.findByIdEstadoVenta", query = "SELECT e FROM EstadoVenta e WHERE e.idEstadoVenta = :idEstadoVenta"),
    @NamedQuery(name = "EstadoVenta.findByNombreTestadoVenta", query = "SELECT e FROM EstadoVenta e WHERE e.nombreTestadoVenta = :nombreTestadoVenta"),
    @NamedQuery(name = "EstadoVenta.findByDescripcion", query = "SELECT e FROM EstadoVenta e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoVenta.findByEstadoExistencia", query = "SELECT e FROM EstadoVenta e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "EstadoVenta.findByFechaRegistro", query = "SELECT e FROM EstadoVenta e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "EstadoVenta.findByFechaModificacion", query = "SELECT e FROM EstadoVenta e WHERE e.fechaModificacion = :fechaModificacion")})
public class EstadoVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_venta")
    private Integer idEstadoVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_testado_venta")
    private String nombreTestadoVenta;
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
    @OneToMany(mappedBy = "estadoVenta", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(mappedBy = "estadoVenta", fetch = FetchType.EAGER)
    private List<Venta> ventaList;

    public EstadoVenta() {
    }

    public EstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }

    public EstadoVenta(Integer idEstadoVenta, String nombreTestadoVenta, String descripcion, int estadoExistencia) {
        this.idEstadoVenta = idEstadoVenta;
        this.nombreTestadoVenta = nombreTestadoVenta;
        this.descripcion = descripcion;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdEstadoVenta() {
        return idEstadoVenta;
    }

    public void setIdEstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }

    public String getNombreTestadoVenta() {
        return nombreTestadoVenta;
    }

    public void setNombreTestadoVenta(String nombreTestadoVenta) {
        this.nombreTestadoVenta = nombreTestadoVenta;
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
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoVenta != null ? idEstadoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoVenta)) {
            return false;
        }
        EstadoVenta other = (EstadoVenta) object;
        if ((this.idEstadoVenta == null && other.idEstadoVenta != null) || (this.idEstadoVenta != null && !this.idEstadoVenta.equals(other.idEstadoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoVenta[ idEstadoVenta=" + idEstadoVenta + " ]";
    }
    
}
