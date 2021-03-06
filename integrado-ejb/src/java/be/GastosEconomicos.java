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
@Table(name = "gastos_economicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastosEconomicos.findAll", query = "SELECT g FROM GastosEconomicos g"),
    @NamedQuery(name = "GastosEconomicos.findByIdGastosEconomicos", query = "SELECT g FROM GastosEconomicos g WHERE g.idGastosEconomicos = :idGastosEconomicos"),
    @NamedQuery(name = "GastosEconomicos.findByMotivo", query = "SELECT g FROM GastosEconomicos g WHERE g.motivo = :motivo"),
    @NamedQuery(name = "GastosEconomicos.findByNota", query = "SELECT g FROM GastosEconomicos g WHERE g.nota = :nota"),
    @NamedQuery(name = "GastosEconomicos.findByFechaCreacion", query = "SELECT g FROM GastosEconomicos g WHERE g.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "GastosEconomicos.findByTotal", query = "SELECT g FROM GastosEconomicos g WHERE g.total = :total"),
    @NamedQuery(name = "GastosEconomicos.findByEstadoExistencia", query = "SELECT g FROM GastosEconomicos g WHERE g.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "GastosEconomicos.findByFechaModificacion", query = "SELECT g FROM GastosEconomicos g WHERE g.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "GastosEconomicos.findByFechaRegistro", query = "SELECT g FROM GastosEconomicos g WHERE g.fechaRegistro = :fechaRegistro")})
public class GastosEconomicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gastos_economicos")
    private Integer idGastosEconomicos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nota")
    private String nota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public GastosEconomicos() {
    }

    public GastosEconomicos(Integer idGastosEconomicos) {
        this.idGastosEconomicos = idGastosEconomicos;
    }

    public GastosEconomicos(Integer idGastosEconomicos, String motivo, String nota, Date fechaCreacion, BigDecimal total, int estadoExistencia) {
        this.idGastosEconomicos = idGastosEconomicos;
        this.motivo = motivo;
        this.nota = nota;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdGastosEconomicos() {
        return idGastosEconomicos;
    }

    public void setIdGastosEconomicos(Integer idGastosEconomicos) {
        this.idGastosEconomicos = idGastosEconomicos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(int estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Empleado getEmpleado2() {
        return empleado2;
    }

    public void setEmpleado2(Empleado empleado2) {
        this.empleado2 = empleado2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGastosEconomicos != null ? idGastosEconomicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosEconomicos)) {
            return false;
        }
        GastosEconomicos other = (GastosEconomicos) object;
        if ((this.idGastosEconomicos == null && other.idGastosEconomicos != null) || (this.idGastosEconomicos != null && !this.idGastosEconomicos.equals(other.idGastosEconomicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.GastosEconomicos[ idGastosEconomicos=" + idGastosEconomicos + " ]";
    }
    
}
