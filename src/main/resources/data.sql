DROP TABLE IF EXISTS CLIENTE;
DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS VENTA;
DROP TABLE IF EXISTS DETALLE_VENTA;

CREATE TABLE CLIENTE(
id_cliente INT AUTO_INCREMENT  PRIMARY KEY,
nombre VARCHAR(250) NOT NULL,
apellido VARCHAR(250) NOT NULL,
dni VARCHAR(250) NOT NULL,
telefono VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL);

CREATE TABLE PRODUCTO(
id_producto INT AUTO_INCREMENT  PRIMARY KEY,
nombre VARCHAR(250) NOT NULL,
precio VARCHAR(250) NOT NULL);

CREATE TABLE VENTA(
id_venta INT AUTO_INCREMENT  PRIMARY KEY,
fecha VARCHAR(250) NOT NULL,
id_cliente VARCHAR(250) NOT NULL,
FOREIGN KEY(id_cliente) REFERENCES CLIENTE(id_cliente));

CREATE TABLE DETALLE_VENTA(
id_detalle_venta INT AUTO_INCREMENT  PRIMARY KEY,
id_venta VARCHAR(250) NOT NULL,
id_producto VARCHAR(250) NOT NULL,
FOREIGN KEY(id_venta) REFERENCES VENTA(id_venta),
FOREIGN KEY(id_producto) REFERENCES PRODUCTO(id_producto));

INSERT INTO cliente(nombre, apellido, dni, telefono, email)  values('juan', 'perez', '10203045', '9633333', 'juan@hotmail.com');
INSERT INTO cliente(nombre, apellido, dni, telefono, email)  values('jose', 'sanchez', '10203046','9633333', 'jose@hotmail.com');
INSERT INTO cliente(nombre, apellido, dni, telefono, email)  values('luis', 'ramirez', '10305089','9633333', 'luis@hotmail.com');
INSERT INTO cliente(nombre, apellido, dni, telefono, email)  values('leonardo', 'valdiviezo', '10405060','9633333', 'leonardo@hotmail.com');


INSERT INTO producto(nombre, precio)  values('mesa', '100');
INSERT INTO producto(nombre, precio)  values('ropero', '200');
INSERT INTO producto(nombre, precio)  values('tv', '300');
INSERT INTO producto(nombre, precio)  values('radio', '400');



INSERT INTO venta(fecha, id_cliente)  values('20/11/2020', '1');
INSERT INTO venta(fecha, id_cliente)  values('15/11/2020', '2');
INSERT INTO venta(fecha, id_cliente)  values('16/11/2020', '3');
INSERT INTO venta(fecha, id_cliente)  values('17/11/2020', '4');

INSERT INTO detalle_venta(id_venta, id_producto)  values('1', '4');
INSERT INTO detalle_venta(id_venta, id_producto)  values('2', '3');
INSERT INTO detalle_venta(id_venta, id_producto)  values('3', '2');
INSERT INTO detalle_venta(id_venta, id_producto)  values('4', '1');
