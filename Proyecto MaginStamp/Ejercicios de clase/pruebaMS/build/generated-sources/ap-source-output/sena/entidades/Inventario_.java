package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Proveedor;
import sena.entidades.Referencia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, String> existencias;
    public static volatile SingularAttribute<Inventario, String> precio;
    public static volatile SingularAttribute<Inventario, String> entradas;
    public static volatile SingularAttribute<Inventario, Date> fechaInventario;
    public static volatile SingularAttribute<Inventario, Proveedor> idProveedor;
    public static volatile SingularAttribute<Inventario, Referencia> idReferencia;
    public static volatile SingularAttribute<Inventario, Integer> idInventario;
    public static volatile SingularAttribute<Inventario, String> salidas;

}