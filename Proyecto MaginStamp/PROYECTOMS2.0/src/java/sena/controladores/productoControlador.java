/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import javax.servlet.http.Part;
import sena.entidades.Categoria;
import sena.entidades.Producto;
import sena.facades.CategoriaFacade;
import sena.facades.ProductoFacade;

/**
 *
 * @author pc
 */
@Named(value = "productoControlador")
@SessionScoped
public class productoControlador implements Serializable {

    /**
     * Creates a new instance of productoControlador
     */
    public productoControlador() {
    }
    
    @PostConstruct
    public void init() {
        producto = new Producto();
        categoria = new Categoria();
        listaProducto = productoFacade.findAll();      
    }
    
    @EJB
    ProductoFacade productoFacade;
    @EJB
    CategoriaFacade categoriaFacade;   
    
    private Producto producto;
    private Categoria categoria;
    private List<Producto> listaProducto;    
    private Part file;
    private String nombre;
    private String pathReal;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Producto> getListaProducto() {
        listaProducto =  productoFacade.findAll();
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getPath() {
        return pathReal;
    }

    public void setPath(String path) {
        this.pathReal = path;
    }
     public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }
    
    public String subir() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/PROYECTOMS2.0/Archivos/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);

            
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal;
    }
    
    
    public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        producto.setIdProducto(00);
        producto.setDisenio(subir());
        producto.setIdcategoria(categoria);
        productoFacade.create(producto);
        this.getListaProducto();
        context.execute("swal('Producto','Creado exitosamente','success')");
        producto = new Producto();
        
    }

    public void remove(Producto objProducto) {
        RequestContext context = RequestContext.getCurrentInstance();
        productoFacade.remove(objProducto);
        this.getListaProducto();
        context.execute("swal('Eliminado')");
        producto = new Producto();
    }

    public String edit(Producto objProducto) {
        producto = objProducto;
        return "editarProducto";
    }

    public void edit() {
        productoFacade.edit(producto);
    }
}
