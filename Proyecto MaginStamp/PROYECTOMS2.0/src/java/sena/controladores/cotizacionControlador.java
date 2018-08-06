
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
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.context.RequestContext;
import sena.entidades.Cotizacion;
import sena.facades.CotizacionFacade;

/**
 *
 * @author pc
 */
@Named(value = "cotizacionControlador")
@SessionScoped
public class cotizacionControlador implements Serializable {

    /**
     * Creates a new instance of cotizacionControlador
     */
    
    /*METODO VACIO*/
    public cotizacionControlador() {
    }
    
    /*POSTCONSTRUCT*/
     @PostConstruct
    public void init() {
        cotizacion = new Cotizacion();
        listaCotizacion = cotizacionFacade.findAll();
    }
    
    @EJB
    CotizacionFacade cotizacionFacade;

    
    /*ATRIBUTOS*/
    private Cotizacion cotizacion;
    private List<Cotizacion> listaCotizacion;
    private Part file;
    private String nombre;
    private String pathReal;
    

    /*GETTERS && SETTERS*/
    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public List<Cotizacion> getListaCotizacion() {
        listaCotizacion = cotizacionFacade.findAll();
        return listaCotizacion;
    }

    public void setListaCotizacion(List<Cotizacion> listaCotizacion) {
        this.listaCotizacion = listaCotizacion;
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
    
    
    /*METODOS*/
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
            
            path = path.replace("\\", "\\\\");
            cotizacionFacade.cargaDatos(path, "Cotizacion");
            file.delete();
            
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal;
    }
    
    
    public void create() {
        RequestContext context = RequestContext.getCurrentInstance();
        cotizacion.setIdCotizacion(00);
        cotizacion.setDisenioCliente(subir());
        cotizacion.setFecha(new Date());
        cotizacionFacade.create(cotizacion);
        this.getListaCotizacion();
        context.execute("swal('Cotizacion','Creada exitosamente','success')");
        cotizacion = new Cotizacion();
    }
    

    public void remove(Cotizacion objCotizacion) {
        RequestContext context = RequestContext.getCurrentInstance();
        cotizacionFacade.remove(objCotizacion);
        this.getListaCotizacion();
        context.execute("swal('Eliminado')");
        cotizacion = new Cotizacion();
    }

    public String edit(Cotizacion objCotizacion) {
        cotizacion = objCotizacion;
        return "editarCotizacion";
    }

    public void edit() {
        cotizacionFacade.edit(cotizacion);
        cotizacion = new Cotizacion();
    }
    

}
