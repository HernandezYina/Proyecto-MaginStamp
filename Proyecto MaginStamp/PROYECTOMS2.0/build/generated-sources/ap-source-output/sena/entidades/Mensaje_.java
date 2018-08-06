package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Cotizacion;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, Integer> idMensaje;
    public static volatile SingularAttribute<Mensaje, String> asunto;
    public static volatile SingularAttribute<Mensaje, Usuario> idUsuario;
    public static volatile SingularAttribute<Mensaje, Cotizacion> idCotizacion;
    public static volatile SingularAttribute<Mensaje, String> mensaje;
    public static volatile SingularAttribute<Mensaje, String> destinatario;

}