USE proyecto;

CREATE TRIGGER USUARIO_AD 
    AFTER DELETE ON Usuario
	  FOR EACH ROW 
          INSERT INTO copiaUsuario(
                      idUsuario,
					  nombres,
                      apellidos,
                      fechaNacimiento,
                      documento,
					  estado,
                      direccion,
                      cel,
                      telefonoFijo,
					  email,
                      clave,
                      idTipoDocumento,
                      idRol)
                      
             VALUES (OLD.idUsuario,
				  OLD.nombres,
                  OLD.apellidos,
                  OLD.fechaNacimiento,
                  OLD.documento,
                  OLD.estado,
                  OLD.direccion,
                  OLD.cel,
                  OLD.telefonoFijo,
			      OLD.email,
			      OLD.clave,
                  OLD.idTipoDocumento,
				  OLD.idRol);
                  
CREATE TRIGGER FACTURA_AD 
    AFTER DELETE ON Factura
	  FOR EACH ROW 
          INSERT INTO copiaFactura(
                      idFactura,
					  fecha,
                      talla,
                      genero,
                      precioTotal,
					  idUsuario)
  
             VALUES (OLD.idFactura,
				  OLD.fecha,
                  OLD.talla,
                  OLD.genero,
                  OLD.precioTotal,
                  OLD.idUsuario);
                  
CREATE TRIGGER FACTURA_HAS_PRODUCTO_AD 
    AFTER DELETE ON factura_has_producto
	  FOR EACH ROW 
          INSERT INTO copiafactura_has_producto(
                      idDetalle,
					  idFactura,
                      idproducto,
                      cantidad,
                      direccion)
  
             VALUES (OLD.idDetalle,
				  OLD.idFactura,
                  OLD.idproducto,
                  OLD.cantidad,
                  OLD.direccion);
                  
