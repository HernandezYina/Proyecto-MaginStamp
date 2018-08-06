CREATE DATABASE PROYECTO;
USE PROYECTO;

CREATE TABLE TipoDocumento(
  idTipoDocumento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(45) NOT NULL,
  sigla VARCHAR(45) NOT NULL
);


CREATE TABLE Rol(
  idRol INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  descripcion VARCHAR(45) NOT NULL
);


CREATE TABLE Usuario(
  idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  fechaNacimiento DATE,
  documento VARCHAR(45) NOT NULL,
  eestado VARCHAR(45),
  direccion VARCHAR(45) NOT NULL,
  cel VARCHAR(45) NOT NULL,
  telefonoFijo VARCHAR(45) NULL,
  email VARCHAR(45) NOT NULL,
  usuario VARCHAR(45) NOT NULL,
  clave VARCHAR(45) NOT NULL,
  idTipoDocumento INT NOT NULL,
  idRol INT NOT NULL,  
  CONSTRAINT Usuario_TipoDocumento FOREIGN KEY (idTipoDocumento) REFERENCES TipoDocumento (idTipoDocumento),
  CONSTRAINT Usuario_Rol FOREIGN KEY (idRol) REFERENCES Rol (idRol)
);

CREATE TABLE Permiso(
  idPermiso INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  identificador VARCHAR(45) NOT NULL,
  urltext VARCHAR(45) NOT NULL,
  icon VARCHAR(45) NOT NULL,
  idRol INT NOT NULL,
  CONSTRAINT Permisos_Rol FOREIGN KEY (idRol) REFERENCES Rol (idRol)
);

CREATE TABLE Contacto(
  idContacto INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  mensaje MEDIUMTEXT NOT NULL,
  fecha DATE NOT NULL
);

CREATE TABLE Proveedor(
  idProveedor INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  numeroDocumento VARCHAR(45) NOT NULL,
  celular VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL
);

CREATE TABLE TipoCamisa(
  idTipoCamisa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tipoCamisa VARCHAR(50) NOT NULL
);

CREATE TABLE Talla(
  idTalla INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  talla VARCHAR(45) NOT NULL
);

CREATE TABLE Referencia(
  idReferencia INT PRIMARY KEY PRIMARY KEY NOT NULL AUTO_INCREMENT,
  referencia VARCHAR(45) NOT NULL
);

CREATE TABLE Descripcion(
  idDescripcion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(60) NOT NULL
);

CREATE TABLE DisenioClientes(
  idDisenioClientes INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  disenio varchar(45) NOT NULL,
  copyright VARCHAR(45) NULL
);
CREATE TABLE DisenioMagin(
  idDisenioMagin INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  disenio varchar(45) NOT NULL,
  copyright VARCHAR(45) NULL
);
CREATE TABLE PedidoDetalle(
  idPedidoDetalle INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  cantidad VARCHAR(45) NOT NULL,
  direccionEnvio VARCHAR(45) NOT NULL,
  detalles VARCHAR(60) NOT NULL,
  fecha DATE NOT NULL,
  idTipoCamisa INT NOT NULL,
  idTalla INT NOT NULL,
  idReferencia INT NOT NULL,
  idDescripcion INT NOT NULL,
  idDisenioClientes INT NOT NULL,
  idDisenioMagin INT NOT NULL,
  idUsuario INT NOT NULL,
  CONSTRAINT PedidoDetalle_TipoCamisa FOREIGN KEY (idTipoCamisa) REFERENCES TipoCamisa (idTipoCamisa),
  CONSTRAINT PedidoDetalle_Talla FOREIGN KEY (idTalla) REFERENCES Talla (idTalla),
  CONSTRAINT PedidoDetalle_Referencia FOREIGN KEY (idReferencia) REFERENCES Referencia (idReferencia),
  CONSTRAINT PedidoDetalle_Descripcion FOREIGN KEY (idDescripcion) REFERENCES Descripcion (idDescripcion),
  CONSTRAINT PedidoDetalle_DisenioClientes FOREIGN KEY (idDisenioClientes) REFERENCES DisenioClientes (idDisenioClientes),
  CONSTRAINT PedidoDetalle_DisenioMagin FOREIGN KEY (idDisenioMagin) REFERENCES DisenioMagin (idDisenioMagin),
  CONSTRAINT PedidoDetalle_Usuario1 FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
);

CREATE TABLE Factura(
  idFactura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  fechaFacturacion DATE NOT NULL,
  precioTotal VARCHAR(45) NOT NULL,
  idPedidoDetalle INT NOT NULL,
  CONSTRAINT Factura_PedidoDetalle FOREIGN KEY (idPedidoDetalle)  REFERENCES PedidoDetalle (idPedidoDetalle)
);


CREATE TABLE Inventario(
  idInventario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  entradas VARCHAR(45) NOT NULL,
  salidas VARCHAR(45) NOT NULL,
  existencias VARCHAR(45) NOT NULL,
  precio VARCHAR(45) NOT NULL,
  fechaInventario DATE NOT NULL,
  idReferencia INT NOT NULL,
  idProveedor INT NOT NULL,
  CONSTRAINT Inventario_Referencia FOREIGN KEY (idReferencia) REFERENCES Referencia (idReferencia),
  CONSTRAINT Inventario_Proveedor FOREIGN KEY (idProveedor) REFERENCES Proveedor (idProveedor)
);




SELECT  idDisenioMagin,Sum(cantidad) as Ventas from PedidoDetalle
group by idDisenioMagin  order by Sum(cantidad) desc;



SELECT idUsuario AS mejor_comprador from PedidoDetalle group by idUsuario
order by fecha, count(0) desc;

SELECT * FROM PedidoDetalle;