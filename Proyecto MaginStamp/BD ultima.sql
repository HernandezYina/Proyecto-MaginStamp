CREATE DATABASE proyecto CHARACTER SET utf8 COLLATE utf8_general_ci;
USE proyecto;

CREATE TABLE  Categoria (
  idCategoria INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombreCategoria VARCHAR(45) NOT NULL,
  descripcion VARCHAR(45) NULL,
  stock INT NOT NULL
  );

CREATE TABLE Producto (
  idProducto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  disenio VARCHAR(900) NOT NULL,
  nombreProducto VARCHAR(45) NOT NULL,
  precio DECIMAL(30,2) NOT NULL,
  descripcion VARCHAR(500) NULL,
  idcategoria INT NOT NULL,
  CONSTRAINT fk_producto_categoria FOREIGN KEY (idcategoria) REFERENCES categoria (idcategoria)
);


CREATE TABLE Cotizacion(
  idCotizacion INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(50) NOT NULL,
  apellidos VARCHAR(50) NOT NULL,
  email VARCHAR(45) NOT NULL,
  fecha DATE NULL,
  cantidad INT NOT NULL,
  detalles VARCHAR(300) NOT NULL,
  disenioCliente VARCHAR(500) NULL
);

CREATE TABLE Rol(
  idRol INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  descripcion VARCHAR(45) NOT NULL
);


CREATE TABLE TipoDocumento(
  idTipoDocumento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(45) NOT NULL,
  sigla VARCHAR(45) NOT NULL
);


CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(45) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    fechaNacimiento DATE NULL,
    fechaRegistro DATE NULL,
    documento VARCHAR(45) NOT NULL,
    estado VARCHAR(45) NULL,
    direccion VARCHAR(45) NOT NULL,
    cel VARCHAR(45) NOT NULL,
    telefonoFijo VARCHAR(45) NULL,
    email VARCHAR(45) NOT NULL,
    clave VARCHAR(45) NOT NULL,
    disenioCamiseta VARCHAR(200) NULL,
    idTipoDocumento INT NOT NULL,
    idRol INT NOT NULL,
    CONSTRAINT Usuario_TipoDocumento FOREIGN KEY (idTipoDocumento)
        REFERENCES TipoDocumento (idTipoDocumento),
    CONSTRAINT Usuario_Rol FOREIGN KEY (idRol)
        REFERENCES Rol (idRol)
);


CREATE TABLE Factura (
  idFactura INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  fecha DATE NOT NULL,
  talla VARCHAR(45) NOT NULL,
  genero VARCHAR(45) NOT NULL,
  precioTotal DECIMAL(30,2) NOT NULL,
  idUsuario INT(11) NOT NULL,
  CONSTRAINT fk_factura_usuario1 FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);


CREATE TABLE Proveedor(
  idProveedor INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  numeroDocumento VARCHAR(45) NOT NULL,
  celular VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  idCategoria INT NOT NULL,
  CONSTRAINT Proveedor_Categoria FOREIGN KEY (idCategoria) REFERENCES Categoria (idCategoria)
);

CREATE TABLE Inventario(
  idInventario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  entradas INT NOT NULL,
  existencias INT,
  fechaInventario DATE NULL,
  idCategoria INT NOT NULL,
  CONSTRAINT Inventario_Categoria FOREIGN KEY (idCategoria) REFERENCES Categoria (idCategoria)
);


CREATE TABLE Mensaje (
  idMensaje INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  destinatario VARCHAR(45) NULL,
  asunto VARCHAR(45) NULL,
  mensaje VARCHAR(300) NULL,
  idCotizacion INT NULL,
  idUsuario INT NULL,
  CONSTRAINT Usuario_id FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario),
  CONSTRAINT Mensaje_Cotizacion FOREIGN KEY (idCotizacion) REFERENCES Cotizacion (idCotizacion)
  );



CREATE TABLE  factura_has_producto (
  idDetalle INT  PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idFactura INT NOT NULL,
  idproducto INT NOT NULL,
  cantidad INT NOT NULL,
  direccion VARCHAR(45) NOT NULL,
  CONSTRAINT fk_factura_has_producto_factura1 FOREIGN KEY (idFactura)  REFERENCES factura (idFactura),
  CONSTRAINT fk_factura_has_producto_producto1 FOREIGN KEY (idproducto) REFERENCES producto (idproducto)
);


CREATE TABLE Personalizado(
  idPersonalizado INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  fecha DATE NULL,
  cantidad INT NOT NULL,
  talla VARCHAR(45) NULL,
  tipoCamisa VARCHAR(45) NULL,
  color VARCHAR(45) NULL,
  detalles VARCHAR(500) NULL,
  disenioCliente VARCHAR(500) NULL,
  disenioClienteTrasero VARCHAR(500) NULL,
  idUsuario INT NOT NULL,
  CONSTRAINT Usuario_Personalizado FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
);

CREATE TABLE Recurso (
  idRecurso INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
  imgPNG VARCHAR(300) NULL,
  imgJPG VARCHAR(45) NULL,
  imgVECTORIAL VARCHAR(45) NULL,
  tipografia VARCHAR(45) NULL,
  idUsuario INT NOT NULL,
  CONSTRAINT Usuario_Recurso FOREIGN KEY (idUsuario) REFERENCES Usuario (idUsuario)
);


-- VOLCADO DE DATOS INICIAL 
INSERT INTO Rol
 VALUES (01,'Administrador','Control total de la aplicacion'),
		(02,'Cliente','Comprador');
 
 
 INSERT INTO TipoDocumento
 VALUES  (01,'Cedula de ciudadania','CC'),
		 (02,'Numero de identificacion tributaria','NIT'),
		 (03,'Cedula de extrangeria','CE'),
		 (04,'Pasaporte','PP');
 
 
 -- VOLCADO DE DATOS INICIAL ADMINISTRADORES
 INSERT INTO Usuario
 VALUES (01,'Neider','Magin Romero','1990/05/20','2018/05/20','121452112','Activo',
		'cra 54 N 25-45','3214859854','70052145','cempresamagin@gmail.com','A123456','',01,01),
        (02,'Camilo','Muñoz Caicedo','1991/01/28','2018/05/20','201354785','Activo',
		'calle 54 N 23-52','3214859854','70052145','cmunoz270@misena.edu.co','A123456','',01,01),
        (03,'Daniela','Galeano Torres','1997/04/03','2018/06/20','32145968','Activo',
		'cra 54 N 25-45','3214859854','70052145','ydgaleano6@misena.edu.co','A123456','',01,01),
        (04,'Esmeralda','Hernandez','2000/06/27','2018/01/20','1007764689','Activo',
		'cra 81 N 71-96','3214859854','70052145','yhernandezbernal@misena.edu.co','A123456','',01,01);


-- VOLCADO DE DATOS stock inicial
INSERT INTO Categoria 
VALUES (01,'Camiseta Manga Corta algodon cuello V','calidad premium',10),
       (02,'Camiseta Manga Corta algodon cuello Circular','calidad premium',10),
       (03,'Camiseta Manga Corta poliester cuello V','calidad premium',10),
       (04,'Camiseta Manga Corta poliester cuello Circular','calidad premium',10),
       (05,'Camiseta Manga Larga algodon cuello V','calidad premium',10),
       (06,'Camiseta Manga Larga algodon cuello Circular','calidad premium',10),
       (07,'Camiseta Manga Larga poliester cuello V','calidad premium',10),
       (08,'Camiseta Manga Larga poliester cuello Circular','calidad premium',10),
       (09,'Buso Capota algodon','calidad premium',10),
       (10,'Camiseta Esqueleto algodon','calidad premium',10);
       

SET lc_time_names = 'es_MX'; -- devolver meses en español (No Borrar)

-- GRAFICA PARA MOSTRAR LOS DISEÑOS MAS SOLICITADOS 
SELECT  idDetalle,Sum(cantidad) as Ventas from factura_has_producto
group by idDetalle  order by Sum(cantidad) desc;

-- GRAFICA NUMERO DE PEDIDOS POR PERSONA POR MES 
SELECT idUsuario AS mejor_comprador from factura group by idUsuario
order by fecha, count(0) desc;

-- GRAFICA NUMERO DE PEDIDOS AL MES
SELECT MonthName(fecha) AS Mes, count(*) AS pedidos_mes from factura
 where fecha >= makedate(year(curdate()), 1) and fecha < makedate(year(curdate()) + 1, 1)
group by MonthName(fecha);

-- GRAFICA total vendido POR MES 
SELECT MonthName(fecha) AS Mes, count(*) AS factura,  sum(precioTotal) AS Total
from factura where fecha >= makedate(year(curdate()), 1)
and fecha < makedate(year(curdate()) + 1, 1)
group by MonthName(fecha);	

-- GRAFICA total REGISTROS POR MES 
SELECT MonthName(fechaRegistro) AS Mes, COUNT(*) AS registros, Year(fechaRegistro) AS anio FROM Usuario 
GROUP BY MONTH(fechaRegistro) ORDER BY fechaRegistro ASC;

-- GRAFICA total COTIZACIONES POR MES
SELECT MonthName(fecha) AS Mes, COUNT(*) AS cotizaciones, Year(fecha) AS anio FROM Cotizacion 
GROUP BY MONTH(fecha) ORDER BY fecha ASC;

-- DISPARADORES EN PHP MYADMIN

-- primer cambio prueba //////////////// --