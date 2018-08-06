-- -----------------------------------------------------
-- basededatos SubirArchivos1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS SubirArchivos1 DEFAULT CHARACTER SET utf8 ;
USE SubirArchivos1;

CREATE TABLE IF NOT EXISTS Empleado(
  idEmpleado INT PRIMARY KEY  AUTO_INCREMENT NOT NULL,
  nombre VARCHAR(45) NULL,
  nDocumento VARCHAR(45) NULL
);

CREATE TABLE IF NOT EXISTS soportes(
  idsoportes INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  Cedula VARCHAR(60) NULL,
  diplomaPregrado VARCHAR(60) NULL,
  experiencia1 VARCHAR(60) NULL,
  experiencia2 VARCHAR(60) NULL,
  Empleado_idEmpleado INT NOT NULL,
  CONSTRAINT Soportes_Empleado
    FOREIGN KEY (Empleado_idEmpleado)
    REFERENCES  Empleado (idEmpleado)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
INSERT INTO `empleado` (`idEmpleado`, `nombre`, `nDocumento`) 
VALUES ('00', 'Emilio', '1071304027'), 
('00', 'Andrea', '1071304023'), 
('00', 'Juliana', '1071304011'), 
('00', 'Johan', '1071304014'), 
('00', 'Carlos', '1071304001');
