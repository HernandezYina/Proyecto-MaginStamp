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
import sena.entidades.Factura;
import sena.facades.FacturaFacade;
/**
 *
 * @author molderos
 */
@Named(value = "facturaControlador")
@SessionScoped
public class facturaControlador implements Serializable {

    /**
     * Creates a new instance of facturaControlador
     */
    
    /*METODO VACIO*/
    public facturaControlador() {
    }
    
    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init (){
       factura = new Factura();
//      producto = new Producto();
       listaFactura = facturaFacade.findAll();
       listaFacturaUs = facturaFacade.findAll();
    }
    
    @EJB
    FacturaFacade facturaFacade;
//     @EJB
//    ProductoFacade productoFacade;

    private Factura factura;
//    private Producto producto;
    private List<Factura> listaFactura;
    private List<Factura> listaFacturaUs;

    
    
    /*METODOS*/
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

//    public Producto getProducto() {
//        return producto;
//    }
//
//    public void setProducto(Producto producto) {
//        this.producto = producto;
//    }
    
    public List<Factura> getListaFactura() {
        listaFactura = facturaFacade.findAll();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public List<Factura> getListaFacturaUs() {
        return listaFacturaUs;
    }

    public void setListaFacturaUs(List<Factura> listaFacturaUs) {
        this.listaFacturaUs = listaFacturaUs;
    }
    
    
    
    public void create() {
        factura.setIdFactura(00);
        facturaFacade.create(factura);
        factura.setFecha(new Date());
        factura = new Factura();
        this.getListaFactura();
    }

    public void remove(Factura objFactura) {
        RequestContext context = RequestContext.getCurrentInstance();
        facturaFacade.remove(objFactura);
        context.execute("const toast = swal.mixin({toast:true, position:'top-end', showConfirmButton: false, timer: 3000}); toast({type: 'success', title: 'Eliminado'});");
        this.getListaFactura();
    }

    public String edit(Factura objFactura) {
        factura = objFactura;
        return "editarFactura";
    }

    public void edit() {
        facturaFacade.edit(factura);
        factura = new Factura();
    }
}
