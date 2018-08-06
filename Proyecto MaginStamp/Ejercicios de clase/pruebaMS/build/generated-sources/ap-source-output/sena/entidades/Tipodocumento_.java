package sena.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sena.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-12T16:31:15")
@StaticMetamodel(Tipodocumento.class)
public class Tipodocumento_ { 

    public static volatile SingularAttribute<Tipodocumento, String> tipo;
    public static volatile SingularAttribute<Tipodocumento, String> sigla;
    public static volatile ListAttribute<Tipodocumento, Usuario> usuarioList;
    public static volatile SingularAttribute<Tipodocumento, Integer> idTipoDocumento;

}