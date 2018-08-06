package sena.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Categoria;
import sena.entidades.FacturaHasProducto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, BigDecimal> precio;
    public static volatile SingularAttribute<Producto, Categoria> idcategoria;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile ListAttribute<Producto, FacturaHasProducto> facturaHasProductoList;
    public static volatile SingularAttribute<Producto, String> disenio;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}