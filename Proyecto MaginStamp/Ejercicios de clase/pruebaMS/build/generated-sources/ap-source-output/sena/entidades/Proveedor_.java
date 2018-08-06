package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Inventario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> apellidos;
    public static volatile SingularAttribute<Proveedor, Integer> idProveedor;
    public static volatile ListAttribute<Proveedor, Inventario> inventarioList;
    public static volatile SingularAttribute<Proveedor, String> celular;
    public static volatile SingularAttribute<Proveedor, String> numeroDocumento;
    public static volatile SingularAttribute<Proveedor, String> nombres;

}