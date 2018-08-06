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
import sena.entidades.Factura;
import sena.entidades.FacturaHasProducto;
import sena.entidades.Producto;
import sena.facades.FacturaFacade;
import sena.facades.FacturaHasProductoFacade;
import sena.facades.ProductoFacade;

/**
 *
 * @author pc
 */
@Named(value = "facturaProductoControlador")
@SessionScoped
public class facturaProductoControlador implements Serializable {

    /**
     * Creates a new instance of facturaProductoControlador
     */
    /*METODO VACIO*/
    public facturaProductoControlador() {
    }
    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init (){
        facturaHasProducto = new FacturaHasProducto (); 
        factura = new Factura ();
        producto = new Producto();
        listaFacturaHasProducto = facturaHasProductoFacade.findAll();
    }
    @EJB
    FacturaHasProductoFacade facturaHasProductoFacade;
    @EJB
    FacturaFacade facturaFacade;
    @EJB
    ProductoFacade productoFacade;
    
    
    
    private FacturaHasProducto facturaHasProducto;
    private Factura factura;
    private Producto producto;
    private List<FacturaHasProducto> listaFacturaHasProducto;

    
    /*GETTERS && SETTERS*/
    public FacturaHasProducto getFacturaHasProducto() {
        return facturaHasProducto;
    }

    public void setFacturaHasProducto(FacturaHasProducto facturaHasProducto) {
        this.facturaHasProducto = facturaHasProducto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<FacturaHasProducto> getListaFacturaHasProducto() {
        return listaFacturaHasProducto;
    }

    public void setListaFacturaHasProducto(List<FacturaHasProducto> listaFacturaHasProducto) {
        this.listaFacturaHasProducto = listaFacturaHasProducto;
    }
    
    public void create() {
        facturaHasProducto.setIdDetalle(00);
        facturaHasProductoFacade.create(facturaHasProducto);
        facturaHasProducto.setIdFactura(factura);
        facturaHasProducto.setIdproducto(producto);
        facturaHasProducto = new FacturaHasProducto();
        this.getListaFacturaHasProducto();
    }    
    
    public void remove(FacturaHasProducto objFacturaHasProducto) {
        facturaHasProductoFacade.remove(objFacturaHasProducto);
        facturaHasProducto = new FacturaHasProducto();
    }

    public String edit(FacturaHasProducto objFacturaHasProducto) {
        facturaHasProducto = objFacturaHasProducto;
        return "editarFactura";
    }
    public void edit() {
        facturaHasProductoFacade.edit(facturaHasProducto);
        facturaHasProducto = new FacturaHasProducto();
    }
}
