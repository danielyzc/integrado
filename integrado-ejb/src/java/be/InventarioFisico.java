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
@Table(name = "inventario_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioFisico.findAll", query = "SELECT i FROM InventarioFisico i"),
    @NamedQuery(name = "InventarioFisico.findByIdInventarioFisico", query = "SELECT i FROM InventarioFisico i WHERE i.idInventarioFisico = :idInventarioFisico"),
    @NamedQuery(name = "InventarioFisico.findByObervaciones", query = "SELECT i FROM InventarioFisico i WHERE i.obervaciones = :obervaciones"),
    @NamedQuery(name = "InventarioFisico.findByFechaInicio", query = "SELECT i FROM InventarioFisico i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "InventarioFisico.findByFechaTermino", query = "SELECT i FROM InventarioFisico i WHERE i.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "InventarioFisico.findByEstadoExistencia", query = "SELECT i FROM InventarioFisico i WHERE i.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "InventarioFisico.findByFechaRegistro", query = "SELECT i FROM InventarioFisico i WHERE i.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "InventarioFisico.findByFechaModificacion", query = "SELECT i FROM InventarioFisico i WHERE i.fechaModificacion = :fechaModificacion")})
public class InventarioFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inventario_fisico")
    private Integer idInventarioFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "obervaciones")
    private String obervaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioFisico", fetch = FetchType.EAGER)
    private List<InventarioInicialSistema> inventarioInicialSistemaList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioFisico", fetch = FetchType.EAGER)
    private List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList;

    public InventarioFisico() {
    }

    public InventarioFisico(Integer idInventarioFisico) {
        this.idInventarioFisico = idInventarioFisico;
    }

    public InventarioFisico(Integer idInventarioFisico, String obervaciones, Date fechaInicio, Date fechaTermino, int estadoExistencia) {
        this.idInventarioFisico = idInventarioFisico;
        this.obervaciones = obervaciones;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdInventarioFisico() {
        return idInventarioFisico;
    }

    public void setIdInventarioFisico(Integer idInventarioFisico) {
        this.idInventarioFisico = idInventarioFisico;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
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
    public List<InventarioInicialSistema> getInventarioInicialSistemaList() {
        return inventarioInicialSistemaList;
    }

    public void setInventarioInicialSistemaList(List<InventarioInicialSistema> inventarioInicialSistemaList) {
        this.inventarioInicialSistemaList = inventarioInicialSistemaList;
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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public List<DetalleInventarioUbicacionFisica> getDetalleInventarioUbicacionFisicaList() {
        return detalleInventarioUbicacionFisicaList;
    }

    public void setDetalleInventarioUbicacionFisicaList(List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList) {
        this.detalleInventarioUbicacionFisicaList = detalleInventarioUbicacionFisicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventarioFisico != null ? idInventarioFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioFisico)) {
            return false;
        }
        InventarioFisico other = (InventarioFisico) object;
        if ((this.idInventarioFisico == null && other.idInventarioFisico != null) || (this.idInventarioFisico != null && !this.idInventarioFisico.equals(other.idInventarioFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.InventarioFisico[ idInventarioFisico=" + idInventarioFisico + " ]";
    }
    
}
