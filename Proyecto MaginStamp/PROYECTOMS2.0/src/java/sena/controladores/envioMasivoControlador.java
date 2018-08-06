/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import sena.clases.correo;
import sena.entidades.Usuario;
import sena.facades.UsuarioFacade;

/**
 *
 * @author pc
 */
@Named(value = "envioMasivoControlador")
@SessionScoped
public class envioMasivoControlador implements Serializable {

    /*METODO VACIO*/
    public envioMasivoControlador() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        Listamasivo = usuarioFacade.findAll();
    }
    /*POSTCONSTRUCT*/
    @EJB
    UsuarioFacade usuarioFacade;

    private List<Usuario> Listamasivo;

    /*ATRIBUTOS*/
    private Usuario usuario;
    private String asuntoM;
    private String cuerpoM;

    /*GETTERS && SETTERS*/
    public List<Usuario> getListamasivo() {
        Listamasivo = usuarioFacade.findAll();
        return Listamasivo;
    }

    public void setListamasivo(List<Usuario> Listamasivo) {
        this.Listamasivo = Listamasivo;
    }

    public String getAsuntoM() {
        return asuntoM;
    }

    public void setAsuntoM(String asuntoM) {
        this.asuntoM = asuntoM;
    }

    public String getCuerpoM() {
        return cuerpoM;
    }

    public void setCuerpoM(String cuerpoM) {
        this.cuerpoM = cuerpoM;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> miLista = new ArrayList<>();
        try {
            return usuarioFacade.findAll();
        } catch (Exception e) {
            return miLista;
        }
    }

    public void envioMasivo() {

        RequestContext contex = RequestContext.getCurrentInstance(); // solucionado
        try {
            correo.sendmasivo("cempresamagin@gmail.com", "spartanjhon117", Listamasivo, getAsuntoM(), getCuerpoM());
            contex.execute("swal('Correos !','Enviados terminado', 'success');");
        } catch (Exception e) {

            contex.execute("swal('error')");
        }
    }

}
