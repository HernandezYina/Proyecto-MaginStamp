/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import sena.entidades.Categoria;
import sena.entidades.Inventario;
import sena.facades.CategoriaFacade;
import sena.facades.InventarioFacade;

/**
 *
 * @author molderos
 */
@Named(value = "inventarioControlador")
@SessionScoped
public class inventarioControlador implements Serializable {

    /**
     * Creates a new instance of inventarioControlador
     */
    
    /*METODO VACIO*/
    public inventarioControlador() {
    }
    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init (){
       inventario = new Inventario();
       categoria = new Categoria();
       listaInventario = inventarioFacade.findAll();
    }
    
    @EJB
    InventarioFacade inventarioFacade;
    @EJB
    CategoriaFacade categoriaFacade;

    
    /*ATRIBUTOS*/
    private Inventario inventario;
    private Categoria categoria;
    private int stock;
    private List<Inventario> listaInventario;
    
    
    /*GETTERS && SETTERS*/
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public List<Inventario> getListaInventario() {
        listaInventario = inventarioFacade.findAll();
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }
    
    
    public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        inventario.setIdInventario(00);
        inventario.setFechaInventario(new Date());
        inventario.setIdCategoria(categoria);
        inventarioFacade.create(inventario);
        this.getListaInventario();
        context.execute("swal('Inventario','Creado exitosamente','success')");
        inventario = new Inventario();
    }

    public void remove(Inventario objInventario) {
        RequestContext context = RequestContext.getCurrentInstance();
        inventarioFacade.remove(objInventario);
        this.getListaInventario();
        context.execute("swal('Eliminado')");
        inventario = new Inventario();
    }

    public String edit(Inventario objInventario) {
        inventario = objInventario;
        return "editarInventario";
    }

    public void edit() {
        inventarioFacade.edit(inventario);
        inventario = new Inventario();
    }

    public void stock(){
       //inventario no se que hacer hay
    }
    
}
