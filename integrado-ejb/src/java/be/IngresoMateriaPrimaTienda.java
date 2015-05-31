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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ingreso_materia_prima_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findAll", query = "SELECT i FROM IngresoMateriaPrimaTienda i"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByIdIngresoMateriaPrimaTienda", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.idIngresoMateriaPrimaTienda = :idIngresoMateriaPrimaTienda"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByCantidad", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByFechaIngreso", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByMotivo", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByEstadoExistencia", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByFechaRegistro", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByFechaModificacion", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.fechaModificacion = :fechaModificacion")})
public class IngresoMateriaPrimaTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_materia_prima_tienda")
    private Integer idIngresoMateriaPrimaTienda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "motivo")
    private String motivo;
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
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public IngresoMateriaPrimaTienda() {
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda, BigDecimal cantidad, Date fechaIngreso, String motivo, int estadoExistencia) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.motivo = motivo;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdIngresoMateriaPrimaTienda() {
        return idIngresoMateriaPrimaTienda;
    }

    public void setIdIngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Empleado getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(Empleado empleado2) {
        this.empleado2 = empleado2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoMateriaPrimaTienda != null ? idIngresoMateriaPrimaTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoMateriaPrimaTienda)) {
            return false;
        }
        IngresoMateriaPrimaTienda other = (IngresoMateriaPrimaTienda) object;
        if ((this.idIngresoMateriaPrimaTienda == null && other.idIngresoMateriaPrimaTienda != null) || (this.idIngresoMateriaPrimaTienda != null && !this.idIngresoMateriaPrimaTienda.equals(other.idIngresoMateriaPrimaTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoMateriaPrimaTienda[ idIngresoMateriaPrimaTienda=" + idIngresoMateriaPrimaTienda + " ]";
    }
    
}
