package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Factura;
import sena.entidades.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(FacturaHasProducto.class)
public class FacturaHasProducto_ { 

    public static volatile SingularAttribute<FacturaHasProducto, Integer> idDetalle;
    public static volatile SingularAttribute<FacturaHasProducto, Factura> idFactura;
    public static volatile SingularAttribute<FacturaHasProducto, String> direccion;
    public static volatile SingularAttribute<FacturaHasProducto, Integer> cantidad;
    public static volatile SingularAttribute<FacturaHasProducto, Producto> idproducto;

}