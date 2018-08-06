package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Pedidodetalle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fechaFacturacion;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, Pedidodetalle> idPedidoDetalle;
    public static volatile SingularAttribute<Factura, String> precioTotal;

}