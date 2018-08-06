package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile SingularAttribute<Rol, Integer> idRol;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, String> nombre;

}