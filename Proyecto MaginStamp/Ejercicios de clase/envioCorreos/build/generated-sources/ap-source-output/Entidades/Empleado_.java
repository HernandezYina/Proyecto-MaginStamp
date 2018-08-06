package Entidades;

import Entidades.Mensaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-31T17:02:34")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidos;
    public static volatile SingularAttribute<Empleado, String> mail;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile ListAttribute<Empleado, Mensaje> mensajeList;
    public static volatile SingularAttribute<Empleado, String> numeroDocumento;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> nombres;

}