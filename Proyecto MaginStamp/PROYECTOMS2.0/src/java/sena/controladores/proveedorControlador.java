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
import javax.servlet.http.Part;
import org.primefaces.context.RequestContext;
import sena.entidades.Categoria;
import sena.entidades.Proveedor;
import sena.facades.CategoriaFacade;
import sena.facades.ProveedorFacade;

/**
 *
 * @author User
 */
@Named(value = "proveedorControlador")
@SessionScoped
public class proveedorControlador implements Serializable {

    /**
     * Creates a new instance of proveedorControlador
     */
    /*METODO VACIO*/
    public proveedorControlador() {
    }

    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        categoria = new Categoria();
        listaProveedor = proveedorFacade.findAll();
    }

    @EJB
    ProveedorFacade proveedorFacade;
    @EJB
    CategoriaFacade categoriaFacade;

    /*ATRIBUTOS*/
    private Proveedor proveedor;
    private Categoria categoria;
    private List<Proveedor> listaProveedor;
    private Part file;
    private String nombre;
    private String pathReal;


    /*GETTERS && SETTERS*/
     public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Proveedor> getListaProveedor() {
        listaProveedor = proveedorFacade.findAll();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
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

    public String getPathReal() {
        return pathReal;
    }

    public void setPathReal(String pathReal) {
        this.pathReal = pathReal;
    }
    /*METODOS*/
    /*METODO CARGA MASIVA*/
    public String cargar() {
        RequestContext context = RequestContext.getCurrentInstance();
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

            path = path.replace("\\", "\\\\");
            proveedorFacade.cargaDatos(path, "Proveedor");
            file.delete();

            in.close();
            out.close();
            context.execute("const toast = swal.mixin({toast:true, position:'top-end', showConfirmButton: false, timer: 3000}); toast({type: 'success', title: 'Datos cargados'});");
            /*Si esto no funciona matenlo desde context execute*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal;
    }
    
    
     public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        proveedor.setIdProveedor(00);
        proveedor.setIdCategoria(categoria);
        proveedorFacade.create(proveedor);
        this.getListaProveedor();
        context.execute("swal('Proveedor','Creado exitosamente','success')");
        proveedor = new Proveedor();
    }
    
    public void remove(Proveedor objProveedor) {
        RequestContext context = RequestContext.getCurrentInstance();
        proveedorFacade.remove(objProveedor);
        context.execute("const toast = swal.mixin({toast:true, position:'top-end', showConfirmButton: false, timer: 3000}); toast({type: 'success', title: 'Eliminado'});");
        this.getListaProveedor();          
    }

    public String edit(Proveedor objProveedor) {
        proveedor = objProveedor;
        this.getListaProveedor();
        return "editarProveedor";
    }

    public void edit() {
        proveedorFacade.edit(proveedor);
        proveedor = new Proveedor();
    }
        
}
