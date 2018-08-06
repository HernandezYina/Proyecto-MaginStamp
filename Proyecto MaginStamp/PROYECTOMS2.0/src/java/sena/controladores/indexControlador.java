/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sena.entidades.Usuario;
import sena.facades.UsuarioFacade;

/**
 *
 * @author Programacion_Java
 */
@ManagedBean
@ViewScoped
public class indexControlador {

    /**
     * Creates a new instance of indexControlador
     */
    /*METODO VACIO*/
    public indexControlador() {
    }

    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    @EJB
    private UsuarioFacade usuarioEJB;
    private Usuario usuario;

    /*GETTERS && SETTERS*/
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*METODOS*/
    public String iniciarsesion() {
        Usuario usuariolog;
        String redireccion = null;

        try {
            usuariolog = usuarioEJB.iniciarsesion(usuario);
            if (usuariolog != null) {

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLog", usuariolog);
                if (usuariolog.getIdRol().getIdRol() == 1) {
                    redireccion = "Admin/listarUsuario?faces-redirect=true";
                    
                } else if (usuariolog.getIdRol().getIdRol() == 2) {
                    redireccion = "Client/tienda?faces-redirect=true";
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso Usuario Incorrecto", "Usuario Incorrecto"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso Error", "Error"));

        }
        return redireccion;
    }

    //Método para cerrar sesión
    public void cerrarSesion() throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().redirect("../index.xhtml?faces-redirect=true");
        context.execute("const toast = swal.mixin({toast:true, position:'top-end', showConfirmButton: false, timer: 3000}); toast({type: 'success', title: 'sesion cerrada'});");
    }

    //Método para validar si la session esta iniciada y si no,enviar la pagina de error
    public void validarSesion() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
            if (user == null) {
                contex.getExternalContext().redirect("/PROYECTOMS2.0/faces/404.xhtml");
            }
        } catch (IOException e) {

        }
    }

    //Método para mantener la session en el carrito
    public Integer idUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getIdUsuario();
    }

}
