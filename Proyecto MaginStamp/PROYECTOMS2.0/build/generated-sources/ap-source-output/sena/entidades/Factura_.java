package sena.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.FacturaHasProducto;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, String> talla;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, String> genero;
    public static volatile SingularAttribute<Factura, Usuario> idUsuario;
    public static volatile SingularAttribute<Factura, BigDecimal> precioTotal;
    public static volatile ListAttribute<Factura, FacturaHasProducto> facturaHasProductoList;

}