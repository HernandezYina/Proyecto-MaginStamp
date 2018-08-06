/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import sena.entidades.Rol;
import sena.facades.RolFacade;

/**
 *
 * @author molderos
 */
@Named(value = "rolControlador")
@SessionScoped
public class rolControlador implements Serializable {

    /**
     * Creates a new instance of rolControlador
     */
    /*METODO VACIO*/
    public rolControlador() {
    }
    
    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        rol = new Rol();
        listaRol = rolFacade.findAll();
    }
    
    
    @EJB
    RolFacade rolFacade;

    private Rol rol;
    private List<Rol> listaRol;
    
    
    /*GETTERS && SETTERS*/
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRol() {
        listaRol =rolFacade.findAll();
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
    
    /*METODOS*/
     public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        rolFacade.create(rol);
        this.getListaRol();
        context.execute("swal('Rol','Creado exitosamente','success')");
        rol = new Rol();
    
    }

    public void remove(Rol objRol) {
        RequestContext context = RequestContext.getCurrentInstance();
        if (objRol.getIdRol() == 1) {
            context.execute("swal('Aviso', 'No se puede eliminar un administrador', 'warning')");
        } else {
             rolFacade.remove(objRol);
             context.execute("swal('Eliminado')");
        } 
        this.getListaRol();
        rol = new Rol();
    }

    
    public String edit(Rol objRol) {    
        rol = objRol;
        return "editarRol";
    }

    
    public void edit() {
        rolFacade.edit(rol);
        rol = new Rol();
    }
    
  
}
