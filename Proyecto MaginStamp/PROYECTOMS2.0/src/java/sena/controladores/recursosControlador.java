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
import sena.entidades.Recurso;
import sena.entidades.Usuario;
import sena.facades.RecursoFacade;
import sena.facades.UsuarioFacade;

/**
 *
 * @author pc
 */
@Named(value = "recursosControlador")
@SessionScoped
public class recursosControlador implements Serializable {

    /**
     * Creates a new instance of recursosControlador
     */
    public recursosControlador() {
    }
    
    @PostConstruct    
    public void init() {
        recurso = new Recurso();
        listaRecurso = recursoFacade.findAll();
        usuario = new Usuario();
    }

    @EJB
    RecursoFacade recursoFacade;
    @EJB
    UsuarioFacade usuarioFacade;


    private Usuario usuario;
    private Recurso recurso;
    private List<Recurso> listaRecurso;
    
    private Part file;
    private String nombre;
    private String pathReal;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public List<Recurso> getListaRecurso() {
        // Actualizar la lista 
        listaRecurso = recursoFacade.findAll();
        return listaRecurso;
    }

    public void setListaRecurso(List<Recurso> listaRecurso) {
        this.listaRecurso = listaRecurso;
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
    public String subirRecurso() {
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
        recurso.setIdRecurso(00);
//        setteo de el ususario por sessión
        usuario.setIdUsuario(idUsuarioConectado());
        recurso.setIdUsuario(usuario);
        recurso.setImgJPG(subirRecurso());
        recursoFacade.create(recurso);
        this.getListaRecurso();
    }
    
    // metodo para usuario por sessión
    public Integer idUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getIdUsuario();
    }


}
