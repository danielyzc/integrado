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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "cliente_potencial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientePotencial.findAll", query = "SELECT c FROM ClientePotencial c"),
    @NamedQuery(name = "ClientePotencial.findByIdClientePotencial", query = "SELECT c FROM ClientePotencial c WHERE c.idClientePotencial = :idClientePotencial"),
    @NamedQuery(name = "ClientePotencial.findByClienteRazonSocial", query = "SELECT c FROM ClientePotencial c WHERE c.clienteRazonSocial = :clienteRazonSocial"),
    @NamedQuery(name = "ClientePotencial.findByFechaCumpleanios", query = "SELECT c FROM ClientePotencial c WHERE c.fechaCumpleanios = :fechaCumpleanios"),
    @NamedQuery(name = "ClientePotencial.findByDireccion", query = "SELECT c FROM ClientePotencial c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "ClientePotencial.findByDni", query = "SELECT c FROM ClientePotencial c WHERE c.dni = :dni"),
    @NamedQuery(name = "ClientePotencial.findByFechaModificacion", query = "SELECT c FROM ClientePotencial c WHERE c.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "ClientePotencial.findByFechaRegistro", query = "SELECT c FROM ClientePotencial c WHERE c.fechaRegistro = :fechaRegistro")})
public class ClientePotencial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente_potencial")
    private Integer idClientePotencial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cliente_razon_social")
    private String clienteRazonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cumpleanios")
    @Temporal(TemporalType.DATE)
    private Date fechaCumpleanios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 350)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "dni")
    private String dni;
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

    public ClientePotencial() {
    }

    public ClientePotencial(Integer idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public ClientePotencial(Integer idClientePotencial, String clienteRazonSocial, Date fechaCumpleanios, String direccion, String dni) {
        this.idClientePotencial = idClientePotencial;
        this.clienteRazonSocial = clienteRazonSocial;
        this.fechaCumpleanios = fechaCumpleanios;
        this.direccion = direccion;
        this.dni = dni;
    }

    public Integer getIdClientePotencial() {
        return idClientePotencial;
    }

    public void setIdClientePotencial(Integer idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public String getClienteRazonSocial() {
        return clienteRazonSocial;
    }

    public void setClienteRazonSocial(String clienteRazonSocial) {
        this.clienteRazonSocial = clienteRazonSocial;
    }

    public Date getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(Date fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientePotencial != null ? idClientePotencial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePotencial)) {
            return false;
        }
        ClientePotencial other = (ClientePotencial) object;
        if ((this.idClientePotencial == null && other.idClientePotencial != null) || (this.idClientePotencial != null && !this.idClientePotencial.equals(other.idClientePotencial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ClientePotencial[ idClientePotencial=" + idClientePotencial + " ]";
    }
    
}
