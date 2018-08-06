/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.HojaDeVida;
import Facades.HojaDeVidaFacade;
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

/**
 *
 * @author pc
 */
@Named(value = "cargarControlador")
@SessionScoped
public class cargarControlador implements Serializable {

    /**
     * Creates a new instance of cargarControlador
     */
    
    public cargarControlador() {
    }
    @PostConstruct
    public void init() {
        hojadevida = new HojaDeVida();   
        listaHojaDeVida = hojadevidaFacade.findAll();
    }
    
    @EJB
    HojaDeVidaFacade hojadevidaFacade;
    
    private HojaDeVida hojadevida;
    private List<HojaDeVida> listaHojaDeVida;
    private Part file;
    private String nombre;
    private String pathReal;
    
    
    public HojaDeVida getHojadevida() {
        return hojadevida;
    }

    public void setHojadevida(HojaDeVida hojadevida) {
        this.hojadevida = hojadevida;
    }

    public List<HojaDeVida> getListaHojaDeVida() {
        return listaHojaDeVida;
    }

    public void setListaHojaDeVida(List<HojaDeVida> listaHojaDeVida) {
        this.listaHojaDeVida = listaHojaDeVida;
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
    
    public String cargar() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("ArchivosP");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\ArchivosP\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/Archivos/ArchivosP/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();
            

            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            
             path=path.replace("\\", "\\\\");
             hojadevidaFacade.cargaDatos(path, "HOJA_DE_VIDA");
             file.delete();
            
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Cargado";
    }

    
    
    
    
}
