package Entidades;

import Entidades.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-31T17:02:34")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, Integer> idMensaje;
    public static volatile SingularAttribute<Mensaje, Empleado> idEmpleado;
    public static volatile SingularAttribute<Mensaje, String> correo;
    public static volatile SingularAttribute<Mensaje, String> asunto;
    public static volatile SingularAttribute<Mensaje, String> mensaje;
    public static volatile SingularAttribute<Mensaje, String> destinatario;

}