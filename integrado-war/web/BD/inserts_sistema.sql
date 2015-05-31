insert into negocio(nombre_negocio) values ('COMERCIAL DANIEL');
insert into negocio(nombre_negocio) values ('NEGOCIO SISTEMA');


insert into tienda(nombre_tienda,direccion,ciudad,distrito,telefonos,numero_ruc ,id_negocio)
values('TIENDA SISTEMA','','','','','',1);

insert into tipo_empleado(nombre,descripcion) values ('VENDEDOR','');
insert into tipo_empleado(nombre,descripcion) values ('OTRO','');
insert into empleado(
id_empleado,
id_tienda,
nombre_empleado,
direccion,
telefono,
correo,
usuario,
password,
id_tipo_empleado,
/*agregado daniel ferreteria*/
sueldo_base,
estado_existencia) values (1,1,'YURY DANIEL ZAVALETA DE LA CRUZ','','','','admin','admin',1,0,1);



insert into desarrollador(nombre) values('zavaleta de la cruz, yury daniel');




/*obligatorio*/



insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values('no atendido','no revisado en almacen',now(),1,now(),1);
insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values('atendido','revisado en almacen',now(),1,now(),1);
insert into estado_orden_salida_detalle_almacen_productos(nombre_estado, descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values('eliminado','revuelto',now(),1,now(),1);

insert into estado_igv(nombre_estado, descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values('activo','en funcionamiento',now(),1,now(),1);
insert into estado_igv(nombre_estado, descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values('inactivo','fuera de funcionamiento',now(),1,now(),1);


insert into igv_factura(monto,descripcion,id_estado_igv,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('0.18','18%',1,now(),1,now(),1);	


insert into mercado(nombre_mercado,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('MERCADO SISTEMA','',now(),1,now(),1);




insert into estado_letras_pago_canje(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('letra pendiente','',now(),1,now(),1);
insert into estado_letras_pago_canje(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('letra pagada','',now(),1,now(),1);

insert into estado_canje_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('canje pendiente','',now(),1,now(),1);
insert into estado_canje_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('canje pagado','',now(),1,now(),1);


insert into estado_producto_costo_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('activo','',now(),1,now(),1);
insert into estado_producto_costo_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('inactivo','',now(),1,now(),1);
insert into estado_producto_costo_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('eliminado','',now(),1,now(),1);

insert into procedencia_producto_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('compras proveedores','',now(),1,now(),1);
insert into procedencia_producto_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('produccion interna','',now(),1,now(),1);
insert into procedencia_producto_almacen(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('otro','',now(),1,now(),1);


insert into estado_facturacion_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('sin facturar','',now(),1,now(),1); 
insert into estado_facturacion_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('facturada','',now(),1,now(),1);
insert into estado_facturacion_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('fac.canjeada','',now(),1,now(),1);


insert into modelo_producto(nombre_modelo_producto ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('catergoria 1','descripcion 1',now(),1,now(),1);
insert into color_producto(nombre_color_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('categoria 2','',now(),1,now(),1);
insert into talla_producto(nombre_talla_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('categoria 3','',now(),1,now(),1);
insert into material_producto(nombre_material_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('categoria 4','descripcion cat 4',now(),1,now(),1);


insert into estado_producto(nombre_estado_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('activo','producto en almacen',now(),1,now(),1);
insert into estado_producto(nombre_estado_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('inactivo','producto inactivo',now(),1,now(),1);
insert into estado_producto(nombre_estado_producto,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('cambiado','producto cambiado',now(),1,now(),1);
/*obligatorio*/

insert into tipo_venta(nombre_tipo_venta,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('boleta','ventas con boletas',now(),1,now(),1);
insert into tipo_venta(nombre_tipo_venta,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('factura','ventas con facturas',now(),1,now(),1);

insert into  estado_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('compra pagada','',now(),1,now(),1);
insert into  estado_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('compra al credito','',now(),1,now(),1);
insert into  estado_orden_compra(nombre,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('compra al credito-pagada','',now(),1,now(),1);


/*
para prestacion de servicios
*/

insert into tipo_venta(nombre_tipo_venta,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('boleta-servicios','ventas con boletas ofreciendo servicios',now(),1,now(),1);
insert into tipo_venta(nombre_tipo_venta,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('factura-servicios','ventas con facturas ofreciendo servicios',now(),1,now(),1);




insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('contado','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito-total pagado','',now(),1,now(),1);

/*
para prestacion de servicios
*/

insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('contado-servicio pendiente','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('contado-servicio terminado','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito-servicio pendiente','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito-servicio terminado','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito-servicio terminado-total pagado','',now(),1,now(),1);
insert into estado_venta(nombre_testado_venta ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('credito-servicio pendiente-total pagado','',now(),1,now(),1);




insert into tipo_producto(nombre_tipo_producto ,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values ('GENERICO','',now(),1,now(),1);


/* para codigo de barras bioagrotec */
insert into zona_ciudad(descripcion_zona_ciudad,flag_estado,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values('zona del sistema','si',now(),1,now(),1);
insert into ubicacion_fisica(nombre_ubicacion_fisica,descripcion_ubicacion_fisica,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)
values('7757000000013-ubicacion sistema','sistema',now(),1,now(),1);



insert into tipo_cliente(nombre_tipo_cliente,descripcion,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica)values ('publico','personas del publico',now(),1,now(),1);
insert into cliente(id_mercado,id_tipo_cliente,nombre_cliente,razon_social,
giro_rubro,
contacto,
ruc_cliente,
direccion,
telefono,
celular,
nextel,
correo,
id_zona_ciudad,fecha_registro,id_empleado_crea,fecha_modificacion,id_empleado_modifica) values (1,1,'publico','publico','publico','','','','','','','',1,now(),1,now(),1);




insert into grupo(nombre_grupo,descripcion_grupo) values ('administrador','');

insert into grupo_usuario(id_grupo,id_empleado) values(1,1);

