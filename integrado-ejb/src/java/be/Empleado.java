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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByUsuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password"),
    @NamedQuery(name = "Empleado.findBySueldoBase", query = "SELECT e FROM Empleado e WHERE e.sueldoBase = :sueldoBase"),
    @NamedQuery(name = "Empleado.findByEstadoExistencia", query = "SELECT e FROM Empleado e WHERE e.estadoExistencia = :estadoExistencia"),
    @NamedQuery(name = "Empleado.findBySexo", query = "SELECT e FROM Empleado e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleado.findByFechaRegistro", query = "SELECT e FROM Empleado e WHERE e.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Empleado.findByFechaIncorporacion", query = "SELECT e FROM Empleado e WHERE e.fechaIncorporacion = :fechaIncorporacion"),
    @NamedQuery(name = "Empleado.findByFechaSalida", query = "SELECT e FROM Empleado e WHERE e.fechaSalida = :fechaSalida")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 68)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 170)
    @Column(name = "password")
    private String password;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo_base")
    private BigDecimal sueldoBase;
    @Column(name = "estado_existencia")
    private Integer estadoExistencia;
    @Column(name = "sexo")
    private Integer sexo;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "fecha_incorporacion")
    @Temporal(TemporalType.DATE)
    private Date fechaIncorporacion;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList1;
    @OneToMany(mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TallaProducto> tallaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TallaProducto> tallaProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Mercado> mercadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Mercado> mercadoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ModeloProducto> modeloProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ModeloProducto> modeloProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<GrupoUsuario> grupoUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Actividad> actividadList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ClientePotencial> clientePotencialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ClientePotencial> clientePotencialList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoLetrasPagoCanje> estadoLetrasPagoCanjeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoLetrasPagoCanje> estadoLetrasPagoCanjeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoOrdenSalidaDetalleAlmacenProductos> estadoOrdenSalidaDetalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoOrdenSalidaDetalleAlmacenProductos> estadoOrdenSalidaDetalleAlmacenProductosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ContratoFumigacion> contratoFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ContratoFumigacion> contratoFumigacionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<UnidadMedida> unidadMedidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<UnidadMedida> unidadMedidaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoVenta> estadoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoVenta> estadoVentaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ReporteDesratizacion> reporteDesratizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Formulacion> formulacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Formulacion> formulacionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<Formulacion> formulacionList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoCliente> tipoClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoCliente> tipoClienteList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<InventarioInicialSistema> inventarioInicialSistemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<InventarioInicialSistema> inventarioInicialSistemaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<GastosEconomicos> gastosEconomicosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<GastosEconomicos> gastosEconomicosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<GastosEconomicos> gastosEconomicosList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoProducto> estadoProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoProducto> estadoProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Cambio> cambioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Cambio> cambioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<OrdenCompra> ordenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<OrdenCompra> ordenCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<MaterialProducto> materialProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<MaterialProducto> materialProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoProductoCostoAlmacen> estadoProductoCostoAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoProductoCostoAlmacen> estadoProductoCostoAlmacenList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<MotivoTransladoFactura> motivoTransladoFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<MotivoTransladoFactura> motivoTransladoFacturaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<GuiaRemicion> guiaRemicionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<GuiaRemicion> guiaRemicionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<IgvFactura> igvFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<IgvFactura> igvFacturaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Promocion> promocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Promocion> promocionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<Promocion> promocionList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ProduccionAlmacen> produccionAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ProduccionAlmacen> produccionAlmacenList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<ProduccionAlmacen> produccionAlmacenList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoCompraCredito> pagoCompraCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<PagoCompraCredito> pagoCompraCreditoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<PagoCompraCredito> pagoCompraCreditoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Cliente> clienteList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ColorProducto> colorProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ColorProducto> colorProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<IngresosEconomicos> ingresosEconomicosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<IngresosEconomicos> ingresosEconomicosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<IngresosEconomicos> ingresosEconomicosList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturaCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturaCompraList1;
    @OneToMany(mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturaCompraList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList1;
    @OneToMany(mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ReporteFumigacion> reporteFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<DevolucionLima> devolucionLimaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<DevolucionLima> devolucionLimaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<VentaRapida> ventaRapidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<VentaRapida> ventaRapidaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoIgv> estadoIgvList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoIgv> estadoIgvList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoVenta> tipoVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoVenta> tipoVentaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Venta> ventaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<UbicacionFisica> ubicacionFisicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<UbicacionFisica> ubicacionFisicaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoFacturacionOrdenCompra> estadoFacturacionOrdenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoFacturacionOrdenCompra> estadoFacturacionOrdenCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoElemento> tipoElementoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoElemento> tipoElementoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ZonaCiudad> zonaCiudadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ZonaCiudad> zonaCiudadList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<InventarioFisico> inventarioFisicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<InventarioFisico> inventarioFisicoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Producto> productoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Producto> productoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Proveedor> proveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Proveedor> proveedorList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoOrdenCompra> estadoOrdenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoOrdenCompra> estadoOrdenCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoCuentaContable> tipoCuentaContableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoCuentaContable> tipoCuentaContableList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Conductor> conductorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<Conductor> conductorList1;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_tipo_empleado", referencedColumnName = "id_tipo_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEmpleado tipoEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<NotaCredito> notaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<NotaCredito> notaCreditoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<MateriaPrima> materiaPrimaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<MateriaPrima> materiaPrimaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<EstadoCanjeOrdenCompra> estadoCanjeOrdenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<EstadoCanjeOrdenCompra> estadoCanjeOrdenCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<CanjeOrdenCompra> canjeOrdenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<CanjeOrdenCompra> canjeOrdenCompraList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<CanjeOrdenCompra> canjeOrdenCompraList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<SalidaProductoTienda> salidaProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<SalidaProductoTienda> salidaProductoTiendaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado2", fetch = FetchType.EAGER)
    private List<SalidaProductoTienda> salidaProductoTiendaList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ProcedenciaProductoAlmacen> procedenciaProductoAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<ProcedenciaProductoAlmacen> procedenciaProductoAlmacenList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoProveedor> tipoProveedorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoProveedor> tipoProveedorList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PrecioProducto> precioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<PrecioProducto> precioProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<TipoProducto> tipoProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<TipoProducto> tipoProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<UnidadTransporte> unidadTransporteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<UnidadTransporte> unidadTransporteList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<SubElemento> subElementoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado1", fetch = FetchType.EAGER)
    private List<SubElemento> subElementoList1;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombreEmpleado, String direccion, String telefono, String correo, String usuario, String password) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Integer getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Integer estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @XmlTransient
    public List<PagoFacturaVentaCredito> getPagoFacturaVentaCreditoList() {
        return pagoFacturaVentaCreditoList;
    }

    public void setPagoFacturaVentaCreditoList(List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList) {
        this.pagoFacturaVentaCreditoList = pagoFacturaVentaCreditoList;
    }

    @XmlTransient
    public List<PagoFacturaVentaCredito> getPagoFacturaVentaCreditoList1() {
        return pagoFacturaVentaCreditoList1;
    }

    public void setPagoFacturaVentaCreditoList1(List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList1) {
        this.pagoFacturaVentaCreditoList1 = pagoFacturaVentaCreditoList1;
    }

    @XmlTransient
    public List<PagoFacturaVentaCredito> getPagoFacturaVentaCreditoList2() {
        return pagoFacturaVentaCreditoList2;
    }

    public void setPagoFacturaVentaCreditoList2(List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList2) {
        this.pagoFacturaVentaCreditoList2 = pagoFacturaVentaCreditoList2;
    }

    @XmlTransient
    public List<TallaProducto> getTallaProductoList() {
        return tallaProductoList;
    }

    public void setTallaProductoList(List<TallaProducto> tallaProductoList) {
        this.tallaProductoList = tallaProductoList;
    }

    @XmlTransient
    public List<TallaProducto> getTallaProductoList1() {
        return tallaProductoList1;
    }

    public void setTallaProductoList1(List<TallaProducto> tallaProductoList1) {
        this.tallaProductoList1 = tallaProductoList1;
    }

    @XmlTransient
    public List<Mercado> getMercadoList() {
        return mercadoList;
    }

    public void setMercadoList(List<Mercado> mercadoList) {
        this.mercadoList = mercadoList;
    }

    @XmlTransient
    public List<Mercado> getMercadoList1() {
        return mercadoList1;
    }

    public void setMercadoList1(List<Mercado> mercadoList1) {
        this.mercadoList1 = mercadoList1;
    }

    @XmlTransient
    public List<ModeloProducto> getModeloProductoList() {
        return modeloProductoList;
    }

    public void setModeloProductoList(List<ModeloProducto> modeloProductoList) {
        this.modeloProductoList = modeloProductoList;
    }

    @XmlTransient
    public List<ModeloProducto> getModeloProductoList1() {
        return modeloProductoList1;
    }

    public void setModeloProductoList1(List<ModeloProducto> modeloProductoList1) {
        this.modeloProductoList1 = modeloProductoList1;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList() {
        return grupoUsuarioList;
    }

    public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
        this.grupoUsuarioList = grupoUsuarioList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Actividad> getActividadList1() {
        return actividadList1;
    }

    public void setActividadList1(List<Actividad> actividadList1) {
        this.actividadList1 = actividadList1;
    }

    @XmlTransient
    public List<ClientePotencial> getClientePotencialList() {
        return clientePotencialList;
    }

    public void setClientePotencialList(List<ClientePotencial> clientePotencialList) {
        this.clientePotencialList = clientePotencialList;
    }

    @XmlTransient
    public List<ClientePotencial> getClientePotencialList1() {
        return clientePotencialList1;
    }

    public void setClientePotencialList1(List<ClientePotencial> clientePotencialList1) {
        this.clientePotencialList1 = clientePotencialList1;
    }

    @XmlTransient
    public List<EstadoLetrasPagoCanje> getEstadoLetrasPagoCanjeList() {
        return estadoLetrasPagoCanjeList;
    }

    public void setEstadoLetrasPagoCanjeList(List<EstadoLetrasPagoCanje> estadoLetrasPagoCanjeList) {
        this.estadoLetrasPagoCanjeList = estadoLetrasPagoCanjeList;
    }

    @XmlTransient
    public List<EstadoLetrasPagoCanje> getEstadoLetrasPagoCanjeList1() {
        return estadoLetrasPagoCanjeList1;
    }

    public void setEstadoLetrasPagoCanjeList1(List<EstadoLetrasPagoCanje> estadoLetrasPagoCanjeList1) {
        this.estadoLetrasPagoCanjeList1 = estadoLetrasPagoCanjeList1;
    }

    @XmlTransient
    public List<EstadoOrdenSalidaDetalleAlmacenProductos> getEstadoOrdenSalidaDetalleAlmacenProductosList() {
        return estadoOrdenSalidaDetalleAlmacenProductosList;
    }

    public void setEstadoOrdenSalidaDetalleAlmacenProductosList(List<EstadoOrdenSalidaDetalleAlmacenProductos> estadoOrdenSalidaDetalleAlmacenProductosList) {
        this.estadoOrdenSalidaDetalleAlmacenProductosList = estadoOrdenSalidaDetalleAlmacenProductosList;
    }

    @XmlTransient
    public List<EstadoOrdenSalidaDetalleAlmacenProductos> getEstadoOrdenSalidaDetalleAlmacenProductosList1() {
        return estadoOrdenSalidaDetalleAlmacenProductosList1;
    }

    public void setEstadoOrdenSalidaDetalleAlmacenProductosList1(List<EstadoOrdenSalidaDetalleAlmacenProductos> estadoOrdenSalidaDetalleAlmacenProductosList1) {
        this.estadoOrdenSalidaDetalleAlmacenProductosList1 = estadoOrdenSalidaDetalleAlmacenProductosList1;
    }

    @XmlTransient
    public List<ContratoFumigacion> getContratoFumigacionList() {
        return contratoFumigacionList;
    }

    public void setContratoFumigacionList(List<ContratoFumigacion> contratoFumigacionList) {
        this.contratoFumigacionList = contratoFumigacionList;
    }

    @XmlTransient
    public List<ContratoFumigacion> getContratoFumigacionList1() {
        return contratoFumigacionList1;
    }

    public void setContratoFumigacionList1(List<ContratoFumigacion> contratoFumigacionList1) {
        this.contratoFumigacionList1 = contratoFumigacionList1;
    }

    @XmlTransient
    public List<UnidadMedida> getUnidadMedidaList() {
        return unidadMedidaList;
    }

    public void setUnidadMedidaList(List<UnidadMedida> unidadMedidaList) {
        this.unidadMedidaList = unidadMedidaList;
    }

    @XmlTransient
    public List<UnidadMedida> getUnidadMedidaList1() {
        return unidadMedidaList1;
    }

    public void setUnidadMedidaList1(List<UnidadMedida> unidadMedidaList1) {
        this.unidadMedidaList1 = unidadMedidaList1;
    }

    @XmlTransient
    public List<EstadoVenta> getEstadoVentaList() {
        return estadoVentaList;
    }

    public void setEstadoVentaList(List<EstadoVenta> estadoVentaList) {
        this.estadoVentaList = estadoVentaList;
    }

    @XmlTransient
    public List<EstadoVenta> getEstadoVentaList1() {
        return estadoVentaList1;
    }

    public void setEstadoVentaList1(List<EstadoVenta> estadoVentaList1) {
        this.estadoVentaList1 = estadoVentaList1;
    }

    @XmlTransient
    public List<ReporteDesratizacion> getReporteDesratizacionList() {
        return reporteDesratizacionList;
    }

    public void setReporteDesratizacionList(List<ReporteDesratizacion> reporteDesratizacionList) {
        this.reporteDesratizacionList = reporteDesratizacionList;
    }

    @XmlTransient
    public List<Formulacion> getFormulacionList() {
        return formulacionList;
    }

    public void setFormulacionList(List<Formulacion> formulacionList) {
        this.formulacionList = formulacionList;
    }

    @XmlTransient
    public List<Formulacion> getFormulacionList1() {
        return formulacionList1;
    }

    public void setFormulacionList1(List<Formulacion> formulacionList1) {
        this.formulacionList1 = formulacionList1;
    }

    @XmlTransient
    public List<Formulacion> getFormulacionList2() {
        return formulacionList2;
    }

    public void setFormulacionList2(List<Formulacion> formulacionList2) {
        this.formulacionList2 = formulacionList2;
    }

    @XmlTransient
    public List<IngresoMateriaPrimaTienda> getIngresoMateriaPrimaTiendaList() {
        return ingresoMateriaPrimaTiendaList;
    }

    public void setIngresoMateriaPrimaTiendaList(List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList) {
        this.ingresoMateriaPrimaTiendaList = ingresoMateriaPrimaTiendaList;
    }

    @XmlTransient
    public List<IngresoMateriaPrimaTienda> getIngresoMateriaPrimaTiendaList1() {
        return ingresoMateriaPrimaTiendaList1;
    }

    public void setIngresoMateriaPrimaTiendaList1(List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList1) {
        this.ingresoMateriaPrimaTiendaList1 = ingresoMateriaPrimaTiendaList1;
    }

    @XmlTransient
    public List<IngresoMateriaPrimaTienda> getIngresoMateriaPrimaTiendaList2() {
        return ingresoMateriaPrimaTiendaList2;
    }

    public void setIngresoMateriaPrimaTiendaList2(List<IngresoMateriaPrimaTienda> ingresoMateriaPrimaTiendaList2) {
        this.ingresoMateriaPrimaTiendaList2 = ingresoMateriaPrimaTiendaList2;
    }

    @XmlTransient
    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList() {
        return detalleFormulacionInsumosList;
    }

    public void setDetalleFormulacionInsumosList(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList) {
        this.detalleFormulacionInsumosList = detalleFormulacionInsumosList;
    }

    @XmlTransient
    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList1() {
        return detalleFormulacionInsumosList1;
    }

    public void setDetalleFormulacionInsumosList1(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList1) {
        this.detalleFormulacionInsumosList1 = detalleFormulacionInsumosList1;
    }

    @XmlTransient
    public List<TipoCliente> getTipoClienteList() {
        return tipoClienteList;
    }

    public void setTipoClienteList(List<TipoCliente> tipoClienteList) {
        this.tipoClienteList = tipoClienteList;
    }

    @XmlTransient
    public List<TipoCliente> getTipoClienteList1() {
        return tipoClienteList1;
    }

    public void setTipoClienteList1(List<TipoCliente> tipoClienteList1) {
        this.tipoClienteList1 = tipoClienteList1;
    }

    @XmlTransient
    public List<InventarioInicialSistema> getInventarioInicialSistemaList() {
        return inventarioInicialSistemaList;
    }

    public void setInventarioInicialSistemaList(List<InventarioInicialSistema> inventarioInicialSistemaList) {
        this.inventarioInicialSistemaList = inventarioInicialSistemaList;
    }

    @XmlTransient
    public List<InventarioInicialSistema> getInventarioInicialSistemaList1() {
        return inventarioInicialSistemaList1;
    }

    public void setInventarioInicialSistemaList1(List<InventarioInicialSistema> inventarioInicialSistemaList1) {
        this.inventarioInicialSistemaList1 = inventarioInicialSistemaList1;
    }

    @XmlTransient
    public List<GastosEconomicos> getGastosEconomicosList() {
        return gastosEconomicosList;
    }

    public void setGastosEconomicosList(List<GastosEconomicos> gastosEconomicosList) {
        this.gastosEconomicosList = gastosEconomicosList;
    }

    @XmlTransient
    public List<GastosEconomicos> getGastosEconomicosList1() {
        return gastosEconomicosList1;
    }

    public void setGastosEconomicosList1(List<GastosEconomicos> gastosEconomicosList1) {
        this.gastosEconomicosList1 = gastosEconomicosList1;
    }

    @XmlTransient
    public List<GastosEconomicos> getGastosEconomicosList2() {
        return gastosEconomicosList2;
    }

    public void setGastosEconomicosList2(List<GastosEconomicos> gastosEconomicosList2) {
        this.gastosEconomicosList2 = gastosEconomicosList2;
    }

    @XmlTransient
    public List<StockMateriaPrimaTiendaOrigen> getStockMateriaPrimaTiendaOrigenList() {
        return stockMateriaPrimaTiendaOrigenList;
    }

    public void setStockMateriaPrimaTiendaOrigenList(List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList) {
        this.stockMateriaPrimaTiendaOrigenList = stockMateriaPrimaTiendaOrigenList;
    }

    @XmlTransient
    public List<StockMateriaPrimaTiendaOrigen> getStockMateriaPrimaTiendaOrigenList1() {
        return stockMateriaPrimaTiendaOrigenList1;
    }

    public void setStockMateriaPrimaTiendaOrigenList1(List<StockMateriaPrimaTiendaOrigen> stockMateriaPrimaTiendaOrigenList1) {
        this.stockMateriaPrimaTiendaOrigenList1 = stockMateriaPrimaTiendaOrigenList1;
    }

    @XmlTransient
    public List<EstadoProducto> getEstadoProductoList() {
        return estadoProductoList;
    }

    public void setEstadoProductoList(List<EstadoProducto> estadoProductoList) {
        this.estadoProductoList = estadoProductoList;
    }

    @XmlTransient
    public List<EstadoProducto> getEstadoProductoList1() {
        return estadoProductoList1;
    }

    public void setEstadoProductoList1(List<EstadoProducto> estadoProductoList1) {
        this.estadoProductoList1 = estadoProductoList1;
    }

    @XmlTransient
    public List<Cambio> getCambioList() {
        return cambioList;
    }

    public void setCambioList(List<Cambio> cambioList) {
        this.cambioList = cambioList;
    }

    @XmlTransient
    public List<Cambio> getCambioList1() {
        return cambioList1;
    }

    public void setCambioList1(List<Cambio> cambioList1) {
        this.cambioList1 = cambioList1;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @XmlTransient
    public List<OrdenCompra> getOrdenCompraList1() {
        return ordenCompraList1;
    }

    public void setOrdenCompraList1(List<OrdenCompra> ordenCompraList1) {
        this.ordenCompraList1 = ordenCompraList1;
    }

    @XmlTransient
    public List<MaterialProducto> getMaterialProductoList() {
        return materialProductoList;
    }

    public void setMaterialProductoList(List<MaterialProducto> materialProductoList) {
        this.materialProductoList = materialProductoList;
    }

    @XmlTransient
    public List<MaterialProducto> getMaterialProductoList1() {
        return materialProductoList1;
    }

    public void setMaterialProductoList1(List<MaterialProducto> materialProductoList1) {
        this.materialProductoList1 = materialProductoList1;
    }

    @XmlTransient
    public List<EstadoProductoCostoAlmacen> getEstadoProductoCostoAlmacenList() {
        return estadoProductoCostoAlmacenList;
    }

    public void setEstadoProductoCostoAlmacenList(List<EstadoProductoCostoAlmacen> estadoProductoCostoAlmacenList) {
        this.estadoProductoCostoAlmacenList = estadoProductoCostoAlmacenList;
    }

    @XmlTransient
    public List<EstadoProductoCostoAlmacen> getEstadoProductoCostoAlmacenList1() {
        return estadoProductoCostoAlmacenList1;
    }

    public void setEstadoProductoCostoAlmacenList1(List<EstadoProductoCostoAlmacen> estadoProductoCostoAlmacenList1) {
        this.estadoProductoCostoAlmacenList1 = estadoProductoCostoAlmacenList1;
    }

    @XmlTransient
    public List<MotivoTransladoFactura> getMotivoTransladoFacturaList() {
        return motivoTransladoFacturaList;
    }

    public void setMotivoTransladoFacturaList(List<MotivoTransladoFactura> motivoTransladoFacturaList) {
        this.motivoTransladoFacturaList = motivoTransladoFacturaList;
    }

    @XmlTransient
    public List<MotivoTransladoFactura> getMotivoTransladoFacturaList1() {
        return motivoTransladoFacturaList1;
    }

    public void setMotivoTransladoFacturaList1(List<MotivoTransladoFactura> motivoTransladoFacturaList1) {
        this.motivoTransladoFacturaList1 = motivoTransladoFacturaList1;
    }

    @XmlTransient
    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
    }

    @XmlTransient
    public List<GuiaRemicion> getGuiaRemicionList1() {
        return guiaRemicionList1;
    }

    public void setGuiaRemicionList1(List<GuiaRemicion> guiaRemicionList1) {
        this.guiaRemicionList1 = guiaRemicionList1;
    }

    @XmlTransient
    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList() {
        return prestamoProductoTiendaUsuarioList;
    }

    public void setPrestamoProductoTiendaUsuarioList(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList) {
        this.prestamoProductoTiendaUsuarioList = prestamoProductoTiendaUsuarioList;
    }

    @XmlTransient
    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList1() {
        return prestamoProductoTiendaUsuarioList1;
    }

    public void setPrestamoProductoTiendaUsuarioList1(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList1) {
        this.prestamoProductoTiendaUsuarioList1 = prestamoProductoTiendaUsuarioList1;
    }

    @XmlTransient
    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList2() {
        return prestamoProductoTiendaUsuarioList2;
    }

    public void setPrestamoProductoTiendaUsuarioList2(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList2) {
        this.prestamoProductoTiendaUsuarioList2 = prestamoProductoTiendaUsuarioList2;
    }

    @XmlTransient
    public List<IgvFactura> getIgvFacturaList() {
        return igvFacturaList;
    }

    public void setIgvFacturaList(List<IgvFactura> igvFacturaList) {
        this.igvFacturaList = igvFacturaList;
    }

    @XmlTransient
    public List<IgvFactura> getIgvFacturaList1() {
        return igvFacturaList1;
    }

    public void setIgvFacturaList1(List<IgvFactura> igvFacturaList1) {
        this.igvFacturaList1 = igvFacturaList1;
    }

    @XmlTransient
    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @XmlTransient
    public List<Promocion> getPromocionList1() {
        return promocionList1;
    }

    public void setPromocionList1(List<Promocion> promocionList1) {
        this.promocionList1 = promocionList1;
    }

    @XmlTransient
    public List<Promocion> getPromocionList2() {
        return promocionList2;
    }

    public void setPromocionList2(List<Promocion> promocionList2) {
        this.promocionList2 = promocionList2;
    }

    @XmlTransient
    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
    }

    @XmlTransient
    public List<LetrasPagoCanje> getLetrasPagoCanjeList1() {
        return letrasPagoCanjeList1;
    }

    public void setLetrasPagoCanjeList1(List<LetrasPagoCanje> letrasPagoCanjeList1) {
        this.letrasPagoCanjeList1 = letrasPagoCanjeList1;
    }

    @XmlTransient
    public List<LetrasPagoCanje> getLetrasPagoCanjeList2() {
        return letrasPagoCanjeList2;
    }

    public void setLetrasPagoCanjeList2(List<LetrasPagoCanje> letrasPagoCanjeList2) {
        this.letrasPagoCanjeList2 = letrasPagoCanjeList2;
    }

    @XmlTransient
    public List<SalidaMateriaPrimaTienda> getSalidaMateriaPrimaTiendaList() {
        return salidaMateriaPrimaTiendaList;
    }

    public void setSalidaMateriaPrimaTiendaList(List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList) {
        this.salidaMateriaPrimaTiendaList = salidaMateriaPrimaTiendaList;
    }

    @XmlTransient
    public List<SalidaMateriaPrimaTienda> getSalidaMateriaPrimaTiendaList1() {
        return salidaMateriaPrimaTiendaList1;
    }

    public void setSalidaMateriaPrimaTiendaList1(List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList1) {
        this.salidaMateriaPrimaTiendaList1 = salidaMateriaPrimaTiendaList1;
    }

    @XmlTransient
    public List<SalidaMateriaPrimaTienda> getSalidaMateriaPrimaTiendaList2() {
        return salidaMateriaPrimaTiendaList2;
    }

    public void setSalidaMateriaPrimaTiendaList2(List<SalidaMateriaPrimaTienda> salidaMateriaPrimaTiendaList2) {
        this.salidaMateriaPrimaTiendaList2 = salidaMateriaPrimaTiendaList2;
    }

    @XmlTransient
    public List<ProduccionAlmacen> getProduccionAlmacenList() {
        return produccionAlmacenList;
    }

    public void setProduccionAlmacenList(List<ProduccionAlmacen> produccionAlmacenList) {
        this.produccionAlmacenList = produccionAlmacenList;
    }

    @XmlTransient
    public List<ProduccionAlmacen> getProduccionAlmacenList1() {
        return produccionAlmacenList1;
    }

    public void setProduccionAlmacenList1(List<ProduccionAlmacen> produccionAlmacenList1) {
        this.produccionAlmacenList1 = produccionAlmacenList1;
    }

    @XmlTransient
    public List<ProduccionAlmacen> getProduccionAlmacenList2() {
        return produccionAlmacenList2;
    }

    public void setProduccionAlmacenList2(List<ProduccionAlmacen> produccionAlmacenList2) {
        this.produccionAlmacenList2 = produccionAlmacenList2;
    }

    @XmlTransient
    public List<PagoCompraCredito> getPagoCompraCreditoList() {
        return pagoCompraCreditoList;
    }

    public void setPagoCompraCreditoList(List<PagoCompraCredito> pagoCompraCreditoList) {
        this.pagoCompraCreditoList = pagoCompraCreditoList;
    }

    @XmlTransient
    public List<PagoCompraCredito> getPagoCompraCreditoList1() {
        return pagoCompraCreditoList1;
    }

    public void setPagoCompraCreditoList1(List<PagoCompraCredito> pagoCompraCreditoList1) {
        this.pagoCompraCreditoList1 = pagoCompraCreditoList1;
    }

    @XmlTransient
    public List<PagoCompraCredito> getPagoCompraCreditoList2() {
        return pagoCompraCreditoList2;
    }

    public void setPagoCompraCreditoList2(List<PagoCompraCredito> pagoCompraCreditoList2) {
        this.pagoCompraCreditoList2 = pagoCompraCreditoList2;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Cliente> getClienteList1() {
        return clienteList1;
    }

    public void setClienteList1(List<Cliente> clienteList1) {
        this.clienteList1 = clienteList1;
    }

    @XmlTransient
    public List<ColorProducto> getColorProductoList() {
        return colorProductoList;
    }

    public void setColorProductoList(List<ColorProducto> colorProductoList) {
        this.colorProductoList = colorProductoList;
    }

    @XmlTransient
    public List<ColorProducto> getColorProductoList1() {
        return colorProductoList1;
    }

    public void setColorProductoList1(List<ColorProducto> colorProductoList1) {
        this.colorProductoList1 = colorProductoList1;
    }

    @XmlTransient
    public List<IngresosEconomicos> getIngresosEconomicosList() {
        return ingresosEconomicosList;
    }

    public void setIngresosEconomicosList(List<IngresosEconomicos> ingresosEconomicosList) {
        this.ingresosEconomicosList = ingresosEconomicosList;
    }

    @XmlTransient
    public List<IngresosEconomicos> getIngresosEconomicosList1() {
        return ingresosEconomicosList1;
    }

    public void setIngresosEconomicosList1(List<IngresosEconomicos> ingresosEconomicosList1) {
        this.ingresosEconomicosList1 = ingresosEconomicosList1;
    }

    @XmlTransient
    public List<IngresosEconomicos> getIngresosEconomicosList2() {
        return ingresosEconomicosList2;
    }

    public void setIngresosEconomicosList2(List<IngresosEconomicos> ingresosEconomicosList2) {
        this.ingresosEconomicosList2 = ingresosEconomicosList2;
    }

    @XmlTransient
    public List<FacturaCompra> getFacturaCompraList() {
        return facturaCompraList;
    }

    public void setFacturaCompraList(List<FacturaCompra> facturaCompraList) {
        this.facturaCompraList = facturaCompraList;
    }

    @XmlTransient
    public List<FacturaCompra> getFacturaCompraList1() {
        return facturaCompraList1;
    }

    public void setFacturaCompraList1(List<FacturaCompra> facturaCompraList1) {
        this.facturaCompraList1 = facturaCompraList1;
    }

    @XmlTransient
    public List<FacturaCompra> getFacturaCompraList2() {
        return facturaCompraList2;
    }

    public void setFacturaCompraList2(List<FacturaCompra> facturaCompraList2) {
        this.facturaCompraList2 = facturaCompraList2;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList() {
        return pagoVentaCreditoList;
    }

    public void setPagoVentaCreditoList(List<PagoVentaCredito> pagoVentaCreditoList) {
        this.pagoVentaCreditoList = pagoVentaCreditoList;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList1() {
        return pagoVentaCreditoList1;
    }

    public void setPagoVentaCreditoList1(List<PagoVentaCredito> pagoVentaCreditoList1) {
        this.pagoVentaCreditoList1 = pagoVentaCreditoList1;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList2() {
        return pagoVentaCreditoList2;
    }

    public void setPagoVentaCreditoList2(List<PagoVentaCredito> pagoVentaCreditoList2) {
        this.pagoVentaCreditoList2 = pagoVentaCreditoList2;
    }

    @XmlTransient
    public List<ReporteFumigacion> getReporteFumigacionList() {
        return reporteFumigacionList;
    }

    public void setReporteFumigacionList(List<ReporteFumigacion> reporteFumigacionList) {
        this.reporteFumigacionList = reporteFumigacionList;
    }

    @XmlTransient
    public List<DevolucionLima> getDevolucionLimaList() {
        return devolucionLimaList;
    }

    public void setDevolucionLimaList(List<DevolucionLima> devolucionLimaList) {
        this.devolucionLimaList = devolucionLimaList;
    }

    @XmlTransient
    public List<DevolucionLima> getDevolucionLimaList1() {
        return devolucionLimaList1;
    }

    public void setDevolucionLimaList1(List<DevolucionLima> devolucionLimaList1) {
        this.devolucionLimaList1 = devolucionLimaList1;
    }

    @XmlTransient
    public List<VentaRapida> getVentaRapidaList() {
        return ventaRapidaList;
    }

    public void setVentaRapidaList(List<VentaRapida> ventaRapidaList) {
        this.ventaRapidaList = ventaRapidaList;
    }

    @XmlTransient
    public List<VentaRapida> getVentaRapidaList1() {
        return ventaRapidaList1;
    }

    public void setVentaRapidaList1(List<VentaRapida> ventaRapidaList1) {
        this.ventaRapidaList1 = ventaRapidaList1;
    }

    @XmlTransient
    public List<EstadoIgv> getEstadoIgvList() {
        return estadoIgvList;
    }

    public void setEstadoIgvList(List<EstadoIgv> estadoIgvList) {
        this.estadoIgvList = estadoIgvList;
    }

    @XmlTransient
    public List<EstadoIgv> getEstadoIgvList1() {
        return estadoIgvList1;
    }

    public void setEstadoIgvList1(List<EstadoIgv> estadoIgvList1) {
        this.estadoIgvList1 = estadoIgvList1;
    }

    @XmlTransient
    public List<TipoVenta> getTipoVentaList() {
        return tipoVentaList;
    }

    public void setTipoVentaList(List<TipoVenta> tipoVentaList) {
        this.tipoVentaList = tipoVentaList;
    }

    @XmlTransient
    public List<TipoVenta> getTipoVentaList1() {
        return tipoVentaList1;
    }

    public void setTipoVentaList1(List<TipoVenta> tipoVentaList1) {
        this.tipoVentaList1 = tipoVentaList1;
    }

    @XmlTransient
    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList() {
        return stockProductoTiendaOrigenList;
    }

    public void setStockProductoTiendaOrigenList(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList) {
        this.stockProductoTiendaOrigenList = stockProductoTiendaOrigenList;
    }

    @XmlTransient
    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList1() {
        return stockProductoTiendaOrigenList1;
    }

    public void setStockProductoTiendaOrigenList1(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList1) {
        this.stockProductoTiendaOrigenList1 = stockProductoTiendaOrigenList1;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList1() {
        return facturaVentaList1;
    }

    public void setFacturaVentaList1(List<FacturaVenta> facturaVentaList1) {
        this.facturaVentaList1 = facturaVentaList1;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Venta> getVentaList1() {
        return ventaList1;
    }

    public void setVentaList1(List<Venta> ventaList1) {
        this.ventaList1 = ventaList1;
    }

    @XmlTransient
    public List<UbicacionFisica> getUbicacionFisicaList() {
        return ubicacionFisicaList;
    }

    public void setUbicacionFisicaList(List<UbicacionFisica> ubicacionFisicaList) {
        this.ubicacionFisicaList = ubicacionFisicaList;
    }

    @XmlTransient
    public List<UbicacionFisica> getUbicacionFisicaList1() {
        return ubicacionFisicaList1;
    }

    public void setUbicacionFisicaList1(List<UbicacionFisica> ubicacionFisicaList1) {
        this.ubicacionFisicaList1 = ubicacionFisicaList1;
    }

    @XmlTransient
    public List<EstadoFacturacionOrdenCompra> getEstadoFacturacionOrdenCompraList() {
        return estadoFacturacionOrdenCompraList;
    }

    public void setEstadoFacturacionOrdenCompraList(List<EstadoFacturacionOrdenCompra> estadoFacturacionOrdenCompraList) {
        this.estadoFacturacionOrdenCompraList = estadoFacturacionOrdenCompraList;
    }

    @XmlTransient
    public List<EstadoFacturacionOrdenCompra> getEstadoFacturacionOrdenCompraList1() {
        return estadoFacturacionOrdenCompraList1;
    }

    public void setEstadoFacturacionOrdenCompraList1(List<EstadoFacturacionOrdenCompra> estadoFacturacionOrdenCompraList1) {
        this.estadoFacturacionOrdenCompraList1 = estadoFacturacionOrdenCompraList1;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList1() {
        return ingresoProductoTiendaList1;
    }

    public void setIngresoProductoTiendaList1(List<IngresoProductoTienda> ingresoProductoTiendaList1) {
        this.ingresoProductoTiendaList1 = ingresoProductoTiendaList1;
    }

    @XmlTransient
    public List<IngresoProductoTienda> getIngresoProductoTiendaList2() {
        return ingresoProductoTiendaList2;
    }

    public void setIngresoProductoTiendaList2(List<IngresoProductoTienda> ingresoProductoTiendaList2) {
        this.ingresoProductoTiendaList2 = ingresoProductoTiendaList2;
    }

    @XmlTransient
    public List<TipoElemento> getTipoElementoList() {
        return tipoElementoList;
    }

    public void setTipoElementoList(List<TipoElemento> tipoElementoList) {
        this.tipoElementoList = tipoElementoList;
    }

    @XmlTransient
    public List<TipoElemento> getTipoElementoList1() {
        return tipoElementoList1;
    }

    public void setTipoElementoList1(List<TipoElemento> tipoElementoList1) {
        this.tipoElementoList1 = tipoElementoList1;
    }

    @XmlTransient
    public List<ZonaCiudad> getZonaCiudadList() {
        return zonaCiudadList;
    }

    public void setZonaCiudadList(List<ZonaCiudad> zonaCiudadList) {
        this.zonaCiudadList = zonaCiudadList;
    }

    @XmlTransient
    public List<ZonaCiudad> getZonaCiudadList1() {
        return zonaCiudadList1;
    }

    public void setZonaCiudadList1(List<ZonaCiudad> zonaCiudadList1) {
        this.zonaCiudadList1 = zonaCiudadList1;
    }

    @XmlTransient
    public List<InventarioFisico> getInventarioFisicoList() {
        return inventarioFisicoList;
    }

    public void setInventarioFisicoList(List<InventarioFisico> inventarioFisicoList) {
        this.inventarioFisicoList = inventarioFisicoList;
    }

    @XmlTransient
    public List<InventarioFisico> getInventarioFisicoList1() {
        return inventarioFisicoList1;
    }

    public void setInventarioFisicoList1(List<InventarioFisico> inventarioFisicoList1) {
        this.inventarioFisicoList1 = inventarioFisicoList1;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<Producto> getProductoList1() {
        return productoList1;
    }

    public void setProductoList1(List<Producto> productoList1) {
        this.productoList1 = productoList1;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList1() {
        return proveedorList1;
    }

    public void setProveedorList1(List<Proveedor> proveedorList1) {
        this.proveedorList1 = proveedorList1;
    }

    @XmlTransient
    public List<EstadoOrdenCompra> getEstadoOrdenCompraList() {
        return estadoOrdenCompraList;
    }

    public void setEstadoOrdenCompraList(List<EstadoOrdenCompra> estadoOrdenCompraList) {
        this.estadoOrdenCompraList = estadoOrdenCompraList;
    }

    @XmlTransient
    public List<EstadoOrdenCompra> getEstadoOrdenCompraList1() {
        return estadoOrdenCompraList1;
    }

    public void setEstadoOrdenCompraList1(List<EstadoOrdenCompra> estadoOrdenCompraList1) {
        this.estadoOrdenCompraList1 = estadoOrdenCompraList1;
    }

    @XmlTransient
    public List<TipoCuentaContable> getTipoCuentaContableList() {
        return tipoCuentaContableList;
    }

    public void setTipoCuentaContableList(List<TipoCuentaContable> tipoCuentaContableList) {
        this.tipoCuentaContableList = tipoCuentaContableList;
    }

    @XmlTransient
    public List<TipoCuentaContable> getTipoCuentaContableList1() {
        return tipoCuentaContableList1;
    }

    public void setTipoCuentaContableList1(List<TipoCuentaContable> tipoCuentaContableList1) {
        this.tipoCuentaContableList1 = tipoCuentaContableList1;
    }

    @XmlTransient
    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    @XmlTransient
    public List<Conductor> getConductorList1() {
        return conductorList1;
    }

    public void setConductorList1(List<Conductor> conductorList1) {
        this.conductorList1 = conductorList1;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @XmlTransient
    public List<NotaCredito> getNotaCreditoList() {
        return notaCreditoList;
    }

    public void setNotaCreditoList(List<NotaCredito> notaCreditoList) {
        this.notaCreditoList = notaCreditoList;
    }

    @XmlTransient
    public List<NotaCredito> getNotaCreditoList1() {
        return notaCreditoList1;
    }

    public void setNotaCreditoList1(List<NotaCredito> notaCreditoList1) {
        this.notaCreditoList1 = notaCreditoList1;
    }

    @XmlTransient
    public List<MateriaPrima> getMateriaPrimaList() {
        return materiaPrimaList;
    }

    public void setMateriaPrimaList(List<MateriaPrima> materiaPrimaList) {
        this.materiaPrimaList = materiaPrimaList;
    }

    @XmlTransient
    public List<MateriaPrima> getMateriaPrimaList1() {
        return materiaPrimaList1;
    }

    public void setMateriaPrimaList1(List<MateriaPrima> materiaPrimaList1) {
        this.materiaPrimaList1 = materiaPrimaList1;
    }

    @XmlTransient
    public List<EstadoCanjeOrdenCompra> getEstadoCanjeOrdenCompraList() {
        return estadoCanjeOrdenCompraList;
    }

    public void setEstadoCanjeOrdenCompraList(List<EstadoCanjeOrdenCompra> estadoCanjeOrdenCompraList) {
        this.estadoCanjeOrdenCompraList = estadoCanjeOrdenCompraList;
    }

    @XmlTransient
    public List<EstadoCanjeOrdenCompra> getEstadoCanjeOrdenCompraList1() {
        return estadoCanjeOrdenCompraList1;
    }

    public void setEstadoCanjeOrdenCompraList1(List<EstadoCanjeOrdenCompra> estadoCanjeOrdenCompraList1) {
        this.estadoCanjeOrdenCompraList1 = estadoCanjeOrdenCompraList1;
    }

    @XmlTransient
    public List<CanjeOrdenCompra> getCanjeOrdenCompraList() {
        return canjeOrdenCompraList;
    }

    public void setCanjeOrdenCompraList(List<CanjeOrdenCompra> canjeOrdenCompraList) {
        this.canjeOrdenCompraList = canjeOrdenCompraList;
    }

    @XmlTransient
    public List<CanjeOrdenCompra> getCanjeOrdenCompraList1() {
        return canjeOrdenCompraList1;
    }

    public void setCanjeOrdenCompraList1(List<CanjeOrdenCompra> canjeOrdenCompraList1) {
        this.canjeOrdenCompraList1 = canjeOrdenCompraList1;
    }

    @XmlTransient
    public List<CanjeOrdenCompra> getCanjeOrdenCompraList2() {
        return canjeOrdenCompraList2;
    }

    public void setCanjeOrdenCompraList2(List<CanjeOrdenCompra> canjeOrdenCompraList2) {
        this.canjeOrdenCompraList2 = canjeOrdenCompraList2;
    }

    @XmlTransient
    public List<SalidaProductoTienda> getSalidaProductoTiendaList() {
        return salidaProductoTiendaList;
    }

    public void setSalidaProductoTiendaList(List<SalidaProductoTienda> salidaProductoTiendaList) {
        this.salidaProductoTiendaList = salidaProductoTiendaList;
    }

    @XmlTransient
    public List<SalidaProductoTienda> getSalidaProductoTiendaList1() {
        return salidaProductoTiendaList1;
    }

    public void setSalidaProductoTiendaList1(List<SalidaProductoTienda> salidaProductoTiendaList1) {
        this.salidaProductoTiendaList1 = salidaProductoTiendaList1;
    }

    @XmlTransient
    public List<SalidaProductoTienda> getSalidaProductoTiendaList2() {
        return salidaProductoTiendaList2;
    }

    public void setSalidaProductoTiendaList2(List<SalidaProductoTienda> salidaProductoTiendaList2) {
        this.salidaProductoTiendaList2 = salidaProductoTiendaList2;
    }

    @XmlTransient
    public List<ProcedenciaProductoAlmacen> getProcedenciaProductoAlmacenList() {
        return procedenciaProductoAlmacenList;
    }

    public void setProcedenciaProductoAlmacenList(List<ProcedenciaProductoAlmacen> procedenciaProductoAlmacenList) {
        this.procedenciaProductoAlmacenList = procedenciaProductoAlmacenList;
    }

    @XmlTransient
    public List<ProcedenciaProductoAlmacen> getProcedenciaProductoAlmacenList1() {
        return procedenciaProductoAlmacenList1;
    }

    public void setProcedenciaProductoAlmacenList1(List<ProcedenciaProductoAlmacen> procedenciaProductoAlmacenList1) {
        this.procedenciaProductoAlmacenList1 = procedenciaProductoAlmacenList1;
    }

    @XmlTransient
    public List<TipoProveedor> getTipoProveedorList() {
        return tipoProveedorList;
    }

    public void setTipoProveedorList(List<TipoProveedor> tipoProveedorList) {
        this.tipoProveedorList = tipoProveedorList;
    }

    @XmlTransient
    public List<TipoProveedor> getTipoProveedorList1() {
        return tipoProveedorList1;
    }

    public void setTipoProveedorList1(List<TipoProveedor> tipoProveedorList1) {
        this.tipoProveedorList1 = tipoProveedorList1;
    }

    @XmlTransient
    public List<PrecioProducto> getPrecioProductoList() {
        return precioProductoList;
    }

    public void setPrecioProductoList(List<PrecioProducto> precioProductoList) {
        this.precioProductoList = precioProductoList;
    }

    @XmlTransient
    public List<PrecioProducto> getPrecioProductoList1() {
        return precioProductoList1;
    }

    public void setPrecioProductoList1(List<PrecioProducto> precioProductoList1) {
        this.precioProductoList1 = precioProductoList1;
    }

    @XmlTransient
    public List<TipoProducto> getTipoProductoList() {
        return tipoProductoList;
    }

    public void setTipoProductoList(List<TipoProducto> tipoProductoList) {
        this.tipoProductoList = tipoProductoList;
    }

    @XmlTransient
    public List<TipoProducto> getTipoProductoList1() {
        return tipoProductoList1;
    }

    public void setTipoProductoList1(List<TipoProducto> tipoProductoList1) {
        this.tipoProductoList1 = tipoProductoList1;
    }

    @XmlTransient
    public List<UnidadTransporte> getUnidadTransporteList() {
        return unidadTransporteList;
    }

    public void setUnidadTransporteList(List<UnidadTransporte> unidadTransporteList) {
        this.unidadTransporteList = unidadTransporteList;
    }

    @XmlTransient
    public List<UnidadTransporte> getUnidadTransporteList1() {
        return unidadTransporteList1;
    }

    public void setUnidadTransporteList1(List<UnidadTransporte> unidadTransporteList1) {
        this.unidadTransporteList1 = unidadTransporteList1;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @XmlTransient
    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList1() {
        return ordenSalidaDetalleAlmacenProductosList1;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList1(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList1) {
        this.ordenSalidaDetalleAlmacenProductosList1 = ordenSalidaDetalleAlmacenProductosList1;
    }

    @XmlTransient
    public List<SubElemento> getSubElementoList() {
        return subElementoList;
    }

    public void setSubElementoList(List<SubElemento> subElementoList) {
        this.subElementoList = subElementoList;
    }

    @XmlTransient
    public List<SubElemento> getSubElementoList1() {
        return subElementoList1;
    }

    public void setSubElementoList1(List<SubElemento> subElementoList1) {
        this.subElementoList1 = subElementoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
