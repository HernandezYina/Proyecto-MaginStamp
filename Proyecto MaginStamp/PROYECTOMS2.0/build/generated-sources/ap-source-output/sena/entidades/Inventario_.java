package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Categoria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Integer> existencias;
    public static volatile SingularAttribute<Inventario, Integer> entradas;
    public static volatile SingularAttribute<Inventario, Date> fechaInventario;
    public static volatile SingularAttribute<Inventario, Categoria> idCategoria;
    public static volatile SingularAttribute<Inventario, Integer> idInventario;

}