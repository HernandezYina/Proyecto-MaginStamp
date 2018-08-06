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
import sena.entidades.Personalizado;
import sena.entidades.Usuario;
import sena.facades.PersonalizadoFacade;
import sena.facades.UsuarioFacade;

/**
 *
 * @author pc
 */
@Named(value = "personalizacionControlador")
@SessionScoped
public class personalizacionControlador implements Serializable {

    /**
     * Creates a new instance of personalizacionControlador
     */
    /*METODO VACIO*/
    public personalizacionControlador() {
    }

    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {

        personalizado = new Personalizado();
        listaPersonalizado = personalizadoFacade.findAll();
        usuario = new Usuario();
    }

    @EJB
    PersonalizadoFacade personalizadoFacade;
    @EJB
    UsuarioFacade usuarioFacade;

    private Part file;
    private String nombre;
    private Usuario usuario;
    private String pathReal;
    private Personalizado personalizado;
    private List<Personalizado> listaPersonalizado;

    
    /*GETTERS && SETTERS*/
    public Personalizado getPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(Personalizado personalizado) {
        this.personalizado = personalizado;
    }

    public List<Personalizado> getListaPersonalizado() {
        listaPersonalizado = personalizadoFacade.findAll();
        return listaPersonalizado;
    }

    public void setListaPersonalizado(List<Personalizado> listaPersonalizado) {
        this.listaPersonalizado = listaPersonalizado;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    public String subirDiseño() {
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

//            path = path.replace("\\", "\\\\");
//            personalizadoFacade.cargaDatos(path, "Cotizacion");
//            file.delete();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal;
    }

    
    public void create() {
        personalizado.setIdPersonalizado(00);
        personalizado.setDisenioCliente(subirDiseño());
        personalizado.setFecha(new Date());
//        setteo de el ususario por sessión
        usuario.setIdUsuario(idUsuarioConectado());
        personalizado.setIdUsuario(usuario);
        personalizadoFacade.create(personalizado);
       
        this.getListaPersonalizado();
        personalizado = new Personalizado();
    }

    // metodo para usuario por sessión
    public Integer idUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getIdUsuario();
    }

    
    public void remove(Personalizado objPersonalizado) {
        personalizadoFacade.remove(objPersonalizado);
        personalizado = new Personalizado();
    }

    public String edit(Personalizado objPersonalizado) {
        personalizado = objPersonalizado;
        return "";
    }

    public void edit() {
        personalizadoFacade.edit(personalizado);
        personalizado = new Personalizado();
    }

    
     public String diseñoUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getDisenioCamiseta();
    }
}
