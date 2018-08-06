package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Pedidodetalle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Disenioclientes.class)
public class Disenioclientes_ { 

    public static volatile SingularAttribute<Disenioclientes, String> copyright;
    public static volatile SingularAttribute<Disenioclientes, Integer> idDisenioClientes;
    public static volatile ListAttribute<Disenioclientes, Pedidodetalle> pedidodetalleList;
    public static volatile SingularAttribute<Disenioclientes, byte[]> disenio;

}