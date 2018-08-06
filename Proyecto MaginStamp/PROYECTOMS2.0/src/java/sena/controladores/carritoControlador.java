/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import sena.entidades.Factura;
import sena.entidades.FacturaHasProducto;
import sena.entidades.Producto;
import sena.clases.ProductoSeleccionado;
import sena.entidades.Usuario;
import sena.facades.FacturaFacade;
import sena.facades.FacturaHasProductoFacade;
import sena.facades.ProductoFacade;

/**
 *
 * @author User
 */
@Named(value = "carritoControlador")
@SessionScoped

public class carritoControlador implements Serializable {

    @PostConstruct
    public void init() {
        producto = new Producto();
        factura = new Factura();
        facturaHasproducto = new FacturaHasProducto();
        usuario = new Usuario();
    }

    @EJB
    ProductoFacade productoFacade;
    @EJB
    FacturaHasProductoFacade facturaHasProductoFacade;
    @EJB
    FacturaFacade facturaFacade;

    private Producto producto;
    private Usuario usuario;
    private Factura factura;
    private FacturaHasProducto facturaHasproducto;
    private List<ProductoSeleccionado> listaCarro;
    private String Talla;
    private String Genero;

    public carritoControlador() {
        this.listaCarro = new ArrayList<ProductoSeleccionado>();
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FacturaHasProducto getFacturaHasproducto() {
        return facturaHasproducto;
    }

    public void setFacturaHasproducto(FacturaHasProducto facturaHasproducto) {
        this.facturaHasproducto = facturaHasproducto;
    }

    public List<ProductoSeleccionado> getListaCarro() {
        return listaCarro;
    }

    public void setListaCarro(List<ProductoSeleccionado> listaCarro) {
        this.listaCarro = listaCarro;
    }

    private int stock(Producto producto) {
        for (int i = 0; i < this.listaCarro.size(); i++) {
            if (this.listaCarro.get(i).getProducto().getIdProducto() == producto.getIdProducto()) {
                return i;
            }
        }
        return -1;
    }

    public String AgregarCarrito(Producto producto) {
        int index = this.stock(producto);
        if (index == -1) {
            
            this.listaCarro.add(new ProductoSeleccionado(producto, 1, Talla, Genero));
        }else if (this.listaCarro.get(index).getTalla() != getTalla()) {
            this.listaCarro.add(new ProductoSeleccionado(producto, 1, Talla, Genero));
            
        }
        else if (this.listaCarro.get(index).getTalla() == getTalla()) {
            int cantidad = this.listaCarro.get(index).getCantidad()+1;
            String talla = this.listaCarro.get(index).getTalla();
            String genero = this.listaCarro.get(index).getGenero();
            this.listaCarro.get(index).setCantidad(cantidad);
            this.listaCarro.get(index).setTalla(talla);
            this.listaCarro.get(index).setGenero(genero);
        }
        
        return "carritoTienda";
    }

    public String borrarDelCarro(Producto producto) {
        int index = this.stock(producto);
        this.listaCarro.remove(index);
        return "carritoTienda";
    }

    public double total() {
        double s = 0;
        for (ProductoSeleccionado lista : this.listaCarro) {
            s += lista.getProducto().getPrecio().doubleValue() * lista.getCantidad();
        }
        return s;
    }

    public int RegistroFactura() {
        BigDecimal valorT = new BigDecimal(total());
        factura.setIdFactura(00);
        factura.setFecha(new Date());
        factura.setGenero(Genero);
        factura.setTalla(Talla);
        usuario.setIdUsuario(idUsuarioConectado());
        factura.setIdUsuario(usuario);
        factura.setPrecioTotal(valorT);
        facturaFacade.create(factura);

        return factura.getIdFactura();
    }

    public void RegistroFacturaProducto() {
        for (ProductoSeleccionado productoSeleccionado1 : listaCarro) {
            facturaHasproducto.setIdDetalle(00);
            facturaHasproducto.setCantidad(productoSeleccionado1.getCantidad());
            facturaHasproducto.setDireccion("direccion");
            facturaHasproducto.setIdFactura(factura);
            facturaHasproducto.setIdproducto(productoSeleccionado1.getProducto());
            facturaHasProductoFacade.create(facturaHasproducto);
        }
    }

    public void Compra() {
        RegistroFactura();
        RegistroFacturaProducto();

    }

    public Integer idUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getIdUsuario();
    }
}
