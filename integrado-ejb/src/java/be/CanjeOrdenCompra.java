/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "canje_orden_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CanjeOrdenCompra.findAll", query = "SELECT c FROM CanjeOrdenCompra c"),
    @NamedQuery(name = "CanjeOrdenCompra.findByIdCanjeOrdenCompra", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.idCanjeOrdenCompra = :idCanjeOrdenCompra"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaCreacionCanje", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaCreacionCanje = :fechaCreacionCanje"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaPago", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "CanjeOrdenCompra.findByMontoCanje", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.montoCanje = :montoCanje"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNumeroCuotas", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.numeroCuotas = :numeroCuotas"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNombreBancoPagar", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.nombreBancoPagar = :nombreBancoPagar"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNumeroCuenta", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "CanjeOrdenCompra.findByObservaciones", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.observaciones = :observaciones"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaRegistro", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CanjeOrdenCompra.findByEstadoExistencia", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaModificacion", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaModificacion = :fechaModificacion")})
public class CanjeOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_canje_orden_compra")
    private Integer idCanjeOrdenCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion_canje")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionCanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_canje")
    private BigDecimal montoCanje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cuotas")
    private int numeroCuotas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_banco_pagar")
    private String nombreBancoPagar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 210)
    @Column(name = "numero_cuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_existencia")
    private int estadoExistencia;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canjeOrdenCompra", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_estado_canje_orden_compra", referencedColumnName = "id_estado_canje_orden_compra")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoCanjeOrdenCompra estadoCanjeOrdenCompra;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrdenCompra ordenCompra;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado2;

    public CanjeOrdenCompra() {
    }

    public CanjeOrdenCompra(Integer idCanjeOrdenCompra) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
    }

    public CanjeOrdenCompra(Integer idCanjeOrdenCompra, Date fechaCreacionCanje, Date fechaPago, BigDecimal montoCanje, int numeroCuotas, String nombreBancoPagar, String numeroCuenta, String observaciones, int estadoExistencia) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
        this.fechaCreacionCanje = fechaCreacionCanje;
        this.fechaPago = fechaPago;
        this.montoCanje = montoCanje;
        this.numeroCuotas = numeroCuotas;
        this.nombreBancoPagar = nombreBancoPagar;
        this.numeroCuenta = numeroCuenta;
        this.observaciones = observaciones;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdCanjeOrdenCompra() {
        return idCanjeOrdenCompra;
    }

    public void setIdCanjeOrdenCompra(Integer idCanjeOrdenCompra) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
    }

    public Date getFechaCreacionCanje() {
        return fechaCreacionCanje;
    }

    public void setFechaCreacionCanje(Date fechaCreacionCanje) {
        this.fechaCreacionCanje = fechaCreacionCanje;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMontoCanje() {
        return montoCanje;
    }

    public void setMontoCanje(BigDecimal montoCanje) {
        this.montoCanje = montoCanje;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public String getNombreBancoPagar() {
        return nombreBancoPagar;
    }

    public void setNombreBancoPagar(String nombreBancoPagar) {
        this.nombreBancoPagar = nombreBancoPagar;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    @XmlTransient
    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
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

    public EstadoCanjeOrdenCompra getEstadoCanjeOrdenCompra() {
        return estadoCanjeOrdenCompra;
    }

    public void setEstadoCanjeOrdenCompra(EstadoCanjeOrdenCompra estadoCanjeOrdenCompra) {
        this.estadoCanjeOrdenCompra = estadoCanjeOrdenCompra;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
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
        hash += (idCanjeOrdenCompra != null ? idCanjeOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanjeOrdenCompra)) {
            return false;
        }
        CanjeOrdenCompra other = (CanjeOrdenCompra) object;
        if ((this.idCanjeOrdenCompra == null && other.idCanjeOrdenCompra != null) || (this.idCanjeOrdenCompra != null && !this.idCanjeOrdenCompra.equals(other.idCanjeOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.CanjeOrdenCompra[ idCanjeOrdenCompra=" + idCanjeOrdenCompra + " ]";
    }
    
}
