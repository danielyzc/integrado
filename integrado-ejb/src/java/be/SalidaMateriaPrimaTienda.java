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
@Table(name = "salida_materia_prima_tienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findAll", query = "SELECT s FROM SalidaMateriaPrimaTienda s"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByIdSalidaMateriaPrimaTienda", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.idSalidaMateriaPrimaTienda = :idSalidaMateriaPrimaTienda"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByCantidad", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByFechaSalida", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByMotivo", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.motivo = :motivo"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByEstadoExistencia", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByFechaRegistro", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByFechaModificacion", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.fechaModificacion = :fechaModificacion")})
public class SalidaMateriaPrimaTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida_materia_prima_tienda")
    private Integer idSalidaMateriaPrimaTienda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
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
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public SalidaMateriaPrimaTienda() {
    }

    public SalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
    }

    public SalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda, BigDecimal cantidad, Date fechaSalida, String motivo, int estadoExistencia) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdSalidaMateriaPrimaTienda() {
        return idSalidaMateriaPrimaTienda;
    }

    public void setIdSalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        hash += (idSalidaMateriaPrimaTienda != null ? idSalidaMateriaPrimaTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaMateriaPrimaTienda)) {
            return false;
        }
        SalidaMateriaPrimaTienda other = (SalidaMateriaPrimaTienda) object;
        if ((this.idSalidaMateriaPrimaTienda == null && other.idSalidaMateriaPrimaTienda != null) || (this.idSalidaMateriaPrimaTienda != null && !this.idSalidaMateriaPrimaTienda.equals(other.idSalidaMateriaPrimaTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SalidaMateriaPrimaTienda[ idSalidaMateriaPrimaTienda=" + idSalidaMateriaPrimaTienda + " ]";
    }
    
}
