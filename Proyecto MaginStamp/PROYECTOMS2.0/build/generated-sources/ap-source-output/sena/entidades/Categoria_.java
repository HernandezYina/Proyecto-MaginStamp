package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Inventario;
import sena.entidades.Producto;
import sena.entidades.Proveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile ListAttribute<Categoria, Proveedor> proveedorList;
    public static volatile ListAttribute<Categoria, Producto> productoList;
    public static volatile ListAttribute<Categoria, Inventario> inventarioList;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, Integer> stock;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;

}