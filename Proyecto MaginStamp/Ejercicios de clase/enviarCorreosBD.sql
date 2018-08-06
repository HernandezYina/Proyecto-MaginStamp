CREATE DATABASE GMAIL;
USE GMAIL;



CREATE TABLE  Empleado (
  idEmpleado INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  numeroDocumento VARCHAR(45) NULL,
  nombres VARCHAR(45) NULL,
  apellidos VARCHAR(45) NULL,
  mail VARCHAR(45) NULL,
  telefono VARCHAR(45) NULL);


CREATE TABLE Mensaje (
  idMensaje INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  correo VARCHAR(45) NULL,
  destinatario VARCHAR(45) NULL,
  asunto VARCHAR(45) NULL,
  mensaje VARCHAR(300) NULL,
  idEmpleado INT NOT NULL,
  CONSTRAINT Mensaje_Empleado FOREIGN KEY (idEmpleado) REFERENCES Empleado (idEmpleado));

