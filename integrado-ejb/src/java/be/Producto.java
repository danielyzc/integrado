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
import javax.persistence.OneToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByFechaIngreso", query = "SELECT p FROM Producto p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Producto.findByEstadoExistencia", query = "SELECT p FROM Producto p WHERE p.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "Producto.findByFechaRegistro", query = "SELECT p FROM Producto p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Producto.findByFechaModificacion", query = "SELECT p FROM Producto p WHERE p.fechaModificacion = :fechaModificacion")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<Formulacion> formulacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleFumigacionProducto> detalleFumigacionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetallePromocionProducto> detallePromocionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleCambioProducto> detalleCambioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto1", fetch = FetchType.EAGER)
    private List<DetalleCambioProducto> detalleCambioProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DevolucionLima> devolucionLimaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @JoinColumn(name = "id_empleado_modifica", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "id_empleado_crea", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado1;
    @JoinColumn(name = "id_material_producto", referencedColumnName = "id_material_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MaterialProducto materialProducto;
    @JoinColumn(name = "id_estado_producto", referencedColumnName = "id_estado_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EstadoProducto estadoProducto;
    @JoinColumn(name = "id_talla_producto", referencedColumnName = "id_talla_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TallaProducto tallaProducto;
    @JoinColumn(name = "id_color_producto", referencedColumnName = "id_color_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ColorProducto colorProducto;
    @JoinColumn(name = "id_tipo_producto", referencedColumnName = "id_tipo_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "id_modelo_producto", referencedColumnName = "id_modelo_producto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ModeloProducto modeloProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<SalidaProductoTienda> salidaProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private List<DetalleServicioProducto> detalleServicioProductoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
    private PrecioProducto precioProducto;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, Date fechaIngreso, int estadoExistencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fechaIngreso = fechaIngreso;
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
    public List<DetalleFacturaVentaProducto> getDetalleFacturaVentaProductoList() {
        return detalleFacturaVentaProductoList;
    }

    public void setDetalleFacturaVentaProductoList(List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList) {
        this.detalleFacturaVentaProductoList = detalleFacturaVentaProductoList;
    }

    @XmlTransient
    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    @XmlTransient
    public List<Formulacion> getFormulacionList() {
        return formulacionList;
    }

    public void setFormulacionList(List<Formulacion> formulacionList) {
        this.formulacionList = formulacionList;
    }

    @XmlTransient
    public List<DetalleFumigacionProducto> getDetalleFumigacionProductoList() {
        return detalleFumigacionProductoList;
    }

    public void setDetalleFumigacionProductoList(List<DetalleFumigacionProducto> detalleFumigacionProductoList) {
        this.detalleFumigacionProductoList = detalleFumigacionProductoList;
    }

    @XmlTransient
    public List<DetallePromocionProducto> getDetallePromocionProductoList() {
        return detallePromocionProductoList;
    }

    public void setDetallePromocionProductoList(List<DetallePromocionProducto> detallePromocionProductoList) {
        this.detallePromocionProductoList = detallePromocionProductoList;
    }

    @XmlTransient
    public List<DetalleCambioProducto> getDetalleCambioProductoList() {
        return detalleCambioProductoList;
    }

    public void setDetalleCambioProductoList(List<DetalleCambioProducto> detalleCambioProductoList) {
        this.detalleCambioProductoList = detalleCambioProductoList;
    }

    @XmlTransient
    public List<DetalleCambioProducto> getDetalleCambioProductoList1() {
        return detalleCambioProductoList1;
    }

    public void setDetalleCambioProductoList1(List<DetalleCambioProducto> detalleCambioProductoList1) {
        this.detalleCambioProductoList1 = detalleCambioProductoList1;
    }

    @XmlTransient
    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
    }

    @XmlTransient
    public List<DetalleOrdenCompraProducto> getDetalleOrdenCompraProductoList() {
        return detalleOrdenCompraProductoList;
    }

    public void setDetalleOrdenCompraProductoList(List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList) {
        this.detalleOrdenCompraProductoList = detalleOrdenCompraProductoList;
    }

    @XmlTransient
    public List<DevolucionLima> getDevolucionLimaList() {
        return devolucionLimaList;
    }

    public void setDevolucionLimaList(List<DevolucionLima> devolucionLimaList) {
        this.devolucionLimaList = devolucionLimaList;
    }

    @XmlTransient
    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    @XmlTransient
    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList() {
        return stockProductoTiendaOrigenList;
    }

    public void setStockProductoTiendaOrigenList(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList) {
        this.stockProductoTiendaOrigenList = stockProductoTiendaOrigenList;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
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

    public MaterialProducto getMaterialProducto() {
        return materialProducto;
    }

    public void setMaterialProducto(MaterialProducto materialProducto) {
        this.materialProducto = materialProducto;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public TallaProducto getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(TallaProducto tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public ColorProducto getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(ColorProducto colorProducto) {
        this.colorProducto = colorProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public ModeloProducto getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(ModeloProducto modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    @XmlTransient
    public List<DetalleUbicacionFisicaProducto> getDetalleUbicacionFisicaProductoList() {
        return detalleUbicacionFisicaProductoList;
    }

    public void setDetalleUbicacionFisicaProductoList(List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList) {
        this.detalleUbicacionFisicaProductoList = detalleUbicacionFisicaProductoList;
    }

    @XmlTransient
    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    @XmlTransient
    public List<SalidaProductoTienda> getSalidaProductoTiendaList() {
        return salidaProductoTiendaList;
    }

    public void setSalidaProductoTiendaList(List<SalidaProductoTienda> salidaProductoTiendaList) {
        this.salidaProductoTiendaList = salidaProductoTiendaList;
    }

    @XmlTransient
    public List<DetalleServicioProducto> getDetalleServicioProductoList() {
        return detalleServicioProductoList;
    }

    public void setDetalleServicioProductoList(List<DetalleServicioProducto> detalleServicioProductoList) {
        this.detalleServicioProductoList = detalleServicioProductoList;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(PrecioProducto precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
