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
import sena.entidades.Categoria;
import sena.facades.CategoriaFacade;

/**
 *
 * @author pc
 */
@Named(value = "categoriaControlador")
@SessionScoped
public class categoriaControlador implements Serializable {

    /**
     * Creates a new instance of categoriaControlador
     */
    /*METODO VACIO*/
    public categoriaControlador() {
    }

    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        categoria = new Categoria();
        listaCategoria = categoriaFacade.findAll();
    }

    @EJB
    CategoriaFacade categoriaFacade;

    /*ATRIBUTOS*/
    private Categoria categoria;
    private List<Categoria> listaCategoria;

    /*GETTERS && SETTERS*/
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoria() {
        listaCategoria = categoriaFacade.findAll();
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    /*METODOS*/
    public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        categoria.setIdCategoria(00);
        categoriaFacade.create(categoria);
        context.execute("swal('Categoria','Creado exitosamente','success')");
        this.getListaCategoria();
        categoria = new Categoria();
        //return "registroRol";
    }

    public void remove(Categoria objCategoria) {
        RequestContext context = RequestContext.getCurrentInstance();
        categoriaFacade.remove(objCategoria);
        this.getListaCategoria();
        context.execute("const toast = swal.mixin({toast:true, position:'top-end', showConfirmButton: false, timer: 3000}); toast({type: 'success', title: 'Eliminado'});");
        categoria = new Categoria();
    }

    public String edit(Categoria objCategoria) {
        categoria = objCategoria;
        return "editarCategoria";
    }

    public void edit() {
        categoriaFacade.edit(categoria);
        categoria = new Categoria();
    }

}
