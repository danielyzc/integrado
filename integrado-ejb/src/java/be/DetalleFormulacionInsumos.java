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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "detalle_formulacion_insumos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFormulacionInsumos.findAll", query = "SELECT d FROM DetalleFormulacionInsumos d"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByIdFormulacion", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.detalleFormulacionInsumosPK.idFormulacion = :idFormulacion"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByIdMateriaPrima", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.detalleFormulacionInsumosPK.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByProporcion", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.proporcion = :proporcion"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByEstadoExistencia", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByFechaRegistro", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByFechaModificacion", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.fechaModificacion = :fechaModificacion")})
public class DetalleFormulacionInsumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFormulacionInsumosPK detalleFormulacionInsumosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "proporcion")
    private BigDecimal proporcion;
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
    @JoinColumn(name = "id_materia_prima", referencedColumnName = "id_materia_prima", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "id_formulacion", referencedColumnName = "id_formulacion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Formulacion formulacion;

    public DetalleFormulacionInsumos() {
    }

    public DetalleFormulacionInsumos(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
    }

    public DetalleFormulacionInsumos(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK, BigDecimal proporcion, int estadoExistencia) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
        this.proporcion = proporcion;
        this.estadoExistencia = estadoExistencia;
    }

    public DetalleFormulacionInsumos(int idFormulacion, int idMateriaPrima) {
        this.detalleFormulacionInsumosPK = new DetalleFormulacionInsumosPK(idFormulacion, idMateriaPrima);
    }

    public DetalleFormulacionInsumosPK getDetalleFormulacionInsumosPK() {
        return detalleFormulacionInsumosPK;
    }

    public void setDetalleFormulacionInsumosPK(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
    }

    public BigDecimal getProporcion() {
        return proporcion;
    }

    public void setProporcion(BigDecimal proporcion) {
        this.proporcion = proporcion;
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

    public Formulacion getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(Formulacion formulacion) {
        this.formulacion = formulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFormulacionInsumosPK != null ? detalleFormulacionInsumosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFormulacionInsumos)) {
            return false;
        }
        DetalleFormulacionInsumos other = (DetalleFormulacionInsumos) object;
        if ((this.detalleFormulacionInsumosPK == null && other.detalleFormulacionInsumosPK != null) || (this.detalleFormulacionInsumosPK != null && !this.detalleFormulacionInsumosPK.equals(other.detalleFormulacionInsumosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFormulacionInsumos[ detalleFormulacionInsumosPK=" + detalleFormulacionInsumosPK + " ]";
    }
    
}
