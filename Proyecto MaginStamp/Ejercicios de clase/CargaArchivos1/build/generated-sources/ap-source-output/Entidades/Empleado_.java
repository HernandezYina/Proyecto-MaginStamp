package Entidades;

import Entidades.Soportes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-16T15:18:57")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile ListAttribute<Empleado, Soportes> soportesList;
    public static volatile SingularAttribute<Empleado, String> nDocumento;
    public static volatile SingularAttribute<Empleado, String> nombre;

}