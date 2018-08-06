package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Mensaje;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Cotizacion.class)
public class Cotizacion_ { 

    public static volatile SingularAttribute<Cotizacion, String> apellidos;
    public static volatile SingularAttribute<Cotizacion, Date> fecha;
    public static volatile SingularAttribute<Cotizacion, String> disenioCliente;
    public static volatile ListAttribute<Cotizacion, Mensaje> mensajeList;
    public static volatile SingularAttribute<Cotizacion, Integer> idCotizacion;
    public static volatile SingularAttribute<Cotizacion, String> detalles;
    public static volatile SingularAttribute<Cotizacion, Integer> cantidad;
    public static volatile SingularAttribute<Cotizacion, String> email;
    public static volatile SingularAttribute<Cotizacion, String> nombres;

}