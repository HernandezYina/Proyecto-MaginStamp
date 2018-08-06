package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Pedidodetalle;
import sena.entidades.Rol;
import sena.entidades.Tipodocumento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> documento;
    public static volatile SingularAttribute<Usuario, String> cel;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile SingularAttribute<Usuario, String> telefonoFijo;
    public static volatile ListAttribute<Usuario, Pedidodetalle> pedidodetalleList;
    public static volatile SingularAttribute<Usuario, Tipodocumento> idTipoDocumento;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, String> email;

}