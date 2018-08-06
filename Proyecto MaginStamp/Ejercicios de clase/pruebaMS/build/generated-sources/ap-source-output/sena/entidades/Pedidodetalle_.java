package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Descripcion;
import sena.entidades.Disenioclientes;
import sena.entidades.Diseniomagin;
import sena.entidades.Factura;
import sena.entidades.Referencia;
import sena.entidades.Talla;
import sena.entidades.Tipocamisa;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Pedidodetalle.class)
public class Pedidodetalle_ { 

    public static volatile SingularAttribute<Pedidodetalle, Usuario> idUsuario;
    public static volatile SingularAttribute<Pedidodetalle, Descripcion> idDescripcion;
    public static volatile SingularAttribute<Pedidodetalle, Date> fecha;
    public static volatile SingularAttribute<Pedidodetalle, Disenioclientes> idDisenioClientes;
    public static volatile SingularAttribute<Pedidodetalle, Diseniomagin> idDisenioMagin;
    public static volatile SingularAttribute<Pedidodetalle, Tipocamisa> idtipoCamisa;
    public static volatile ListAttribute<Pedidodetalle, Factura> facturaList;
    public static volatile SingularAttribute<Pedidodetalle, Integer> idPedidoDetalle;
    public static volatile SingularAttribute<Pedidodetalle, String> detalles;
    public static volatile SingularAttribute<Pedidodetalle, Talla> idtalla;
    public static volatile SingularAttribute<Pedidodetalle, String> cantidad;
    public static volatile SingularAttribute<Pedidodetalle, String> direccionEnvio;
    public static volatile SingularAttribute<Pedidodetalle, Referencia> idReferencia;

}