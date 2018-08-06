package sena.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Factura;
import sena.entidades.Mensaje;
import sena.entidades.Personalizado;
import sena.entidades.Recurso;
import sena.entidades.Rol;
import sena.entidades.Tipodocumento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-02T12:46:46")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellidos;
    public static volatile SingularAttribute<Usuario, String> estado;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile SingularAttribute<Usuario, Date> fechaRegistro;
    public static volatile ListAttribute<Usuario, Personalizado> personalizadoList;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile ListAttribute<Usuario, Mensaje> mensajeList;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, String> documento;
    public static volatile SingularAttribute<Usuario, String> cel;
    public static volatile SingularAttribute<Usuario, String> disenioCamiseta;
    public static volatile SingularAttribute<Usuario, String> nombres;
    public static volatile SingularAttribute<Usuario, String> telefonoFijo;
    public static volatile ListAttribute<Usuario, Recurso> recursoList;
    public static volatile SingularAttribute<Usuario, Tipodocumento> idTipoDocumento;
    public static volatile ListAttribute<Usuario, Factura> facturaList;
    public static volatile SingularAttribute<Usuario, String> email;

}