package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Personalizado.class)
public class Personalizado_ { 

    public static volatile SingularAttribute<Personalizado, Date> fecha;
    public static volatile SingularAttribute<Personalizado, String> tipoCamisa;
    public static volatile SingularAttribute<Personalizado, String> disenioCliente;
    public static volatile SingularAttribute<Personalizado, Integer> idPersonalizado;
    public static volatile SingularAttribute<Personalizado, String> talla;
    public static volatile SingularAttribute<Personalizado, String> color;
    public static volatile SingularAttribute<Personalizado, Usuario> idUsuario;
    public static volatile SingularAttribute<Personalizado, String> detalles;
    public static volatile SingularAttribute<Personalizado, String> disenioClienteTrasero;
    public static volatile SingularAttribute<Personalizado, Integer> cantidad;

}