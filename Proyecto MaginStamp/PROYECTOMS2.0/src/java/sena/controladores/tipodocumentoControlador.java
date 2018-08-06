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
import sena.entidades.Tipodocumento;
import sena.facades.TipodocumentoFacade;

/**
 *
 * @author molderos
 */
@Named(value = "tipodocumentoControlador")
@SessionScoped
public class tipodocumentoControlador implements Serializable {

    /**
     * Creates a new instance of tipodocumentoControlador
     */
    
    /*METODO VACIO*/
    public tipodocumentoControlador() {
    }

    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        tipodocumento = new Tipodocumento();
        listaTipodocumento = tipodocumentoFacade.findAll(); //LISTA TIPOS DOCUMENTO
    }

    @EJB
    TipodocumentoFacade tipodocumentoFacade;

    /*ATRIBUTOS*/
    private Tipodocumento tipodocumento;
    private List<Tipodocumento> listaTipodocumento;

    
    /*GETTERS && SETTERS*/
    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public List<Tipodocumento> getListaTipodocumento() {
        listaTipodocumento = tipodocumentoFacade.findAll();
        return listaTipodocumento;
    }

    public void setListaTipodocumento(List<Tipodocumento> listaTipodocumento) {
        this.listaTipodocumento = listaTipodocumento;
    }

    /*METODOS*/
    public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        tipodocumentoFacade.create(tipodocumento);
        this.getListaTipodocumento();
        context.execute("swal('Documento','Creado exitosamente','success')");
        tipodocumento = new Tipodocumento(); 
    }

    public void remove(Tipodocumento objTipodocumento) {
        RequestContext context = RequestContext.getCurrentInstance();
        tipodocumentoFacade.remove(objTipodocumento);
        this.getListaTipodocumento();
        context.execute("swal('Eliminado')");
        tipodocumento = new Tipodocumento();
    }

    public String edit(Tipodocumento objTipodocumento) {
        tipodocumento = objTipodocumento;
        this.getListaTipodocumento();
        return "editarTipodocumento";
    }

    public void edit() {
        tipodocumentoFacade.edit(tipodocumento);
        tipodocumento = new Tipodocumento();
    }

}
