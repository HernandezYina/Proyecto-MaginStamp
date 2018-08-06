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
import sena.entidades.Usuario;
import sena.facades.UsuarioFacade;

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
        usuario = new Usuario();
        listaUsuarios = usuarioFacade.findAll();
    }

    @EJB
    UsuarioFacade usuarioFacade;

    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    private Part file;
    private String nombre;
    private String pathReal;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "PROYECTOMS2.0/Archivos/" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();

            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);

            path = path.replace("\\", "\\\\");
            usuarioFacade.cargaDatos(path, "Usuario");
            file.delete();

            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Cargado";
    }

}
