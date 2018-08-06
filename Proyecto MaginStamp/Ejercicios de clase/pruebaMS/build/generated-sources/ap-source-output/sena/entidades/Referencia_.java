package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Inventario;
import sena.entidades.Pedidodetalle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Referencia.class)
public class Referencia_ { 

    public static volatile ListAttribute<Referencia, Pedidodetalle> pedidodetalleList;
    public static volatile ListAttribute<Referencia, Inventario> inventarioList;
    public static volatile SingularAttribute<Referencia, Integer> idReferencia;
    public static volatile SingularAttribute<Referencia, String> referencia;

}