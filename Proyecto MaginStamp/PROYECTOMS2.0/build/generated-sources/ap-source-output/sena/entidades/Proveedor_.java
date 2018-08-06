package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Categoria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> apellidos;
    public static volatile SingularAttribute<Proveedor, Integer> idProveedor;
    public static volatile SingularAttribute<Proveedor, String> celular;
    public static volatile SingularAttribute<Proveedor, String> numeroDocumento;
    public static volatile SingularAttribute<Proveedor, Categoria> idCategoria;
    public static volatile SingularAttribute<Proveedor, String> email;
    public static volatile SingularAttribute<Proveedor, String> nombres;

}