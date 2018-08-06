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
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.context.RequestContext;
import sena.clases.correo;
import sena.entidades.Rol;
import sena.entidades.Tipodocumento;
import sena.entidades.Usuario;
import sena.facades.RolFacade;
import sena.facades.TipodocumentoFacade;
import sena.facades.UsuarioFacade;

/**
 *
 * @author User
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    /*METODO VACIO*/
    public UsuarioControlador() {
    }

    
    /*POSTCONSTRUCT*/
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        tipodocumento = new Tipodocumento();
        rol = new Rol();
        listaUsuarios = usuarioFacade.findAll();
        listaRol = rolFacade.findAll();
    }

    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    TipodocumentoFacade tipodocumentoFacade;
    @EJB
    RolFacade rolFacade;

    private Usuario usuario;
    private Rol rol;
    private Tipodocumento tipodocumento;
    private List<Usuario> listaUsuarios;
    private List<Rol> listaRol;
    private Part file;
    private String nombre;
    private String pathReal;
    private String estado;
    private String correo;

    
    

    
    
    /*GETTERS && SETTERS*/
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        listaUsuarios = usuarioFacade.findAll(); // ACtualizar la lista 
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
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
    public void create() throws UnsupportedEncodingException {
        RequestContext context = RequestContext.getCurrentInstance();
        usuario.setIdUsuario(00);
        usuario.setFechaRegistro(new Date());
        usuario.setIdTipoDocumento(tipodocumento);
        usuario.setIdRol(rol); //Amor, faltaba esta linea de codigo por eso no registraba
        rol.setIdRol(2);
        usuarioFacade.create(usuario);
        usuario.getEmail();
        sena.clases.correo.sendRegistro(usuario.getEmail(), "Registrado", "Se registro exitosamente "
                + usuario.getNombres() + usuario.getApellidos() + "." + "<br/>" + " El email registrado es: "
                + usuario.getEmail() + "<br/>" + " La clave regristrada es: " + usuario.getClave());
        usuario = new Usuario();
        context.execute("swal('Usuario','Creado exitosamente Bienvenido','success')");
        this.getListaUsuarios();
    }

    
    
    public String edit(Usuario objUsuario) {
        usuario = objUsuario;
        this.getListaUsuarios();
        return "editarUsuario";
        
    }

    public void edit() {
        usuarioFacade.edit(usuario);
    }

    public void remove(Usuario objUsuario) {
        RequestContext context = RequestContext.getCurrentInstance();
        if (objUsuario.getIdRol().getIdRol() == 1) {
            context.execute("swal('Proveedor','No se puede eliminar a un administrador','warning')");
        } else {
            usuarioFacade.remove(objUsuario);
            
            this.getListaUsuarios();
            context.execute("swal('Eliminado')");
           
        }

    }

    
    /*METODOS CARGA DE DATOS MASIVOS*/
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

    
    
    /*METODOS DISEÑO PARA PERSONALIZADO*/
    public String subirDiseño() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos/Uniq");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos/Uniq\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/PROYECTOMS2.0/Archivos/Uniq" + nombre;
            path = path + this.nombre;
            InputStream in = file.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);

//            path = path.replace("\\", "\\\\");
//            cotizacionFacade.cargaDatos(path, "Cotizacion");
//            file.delete();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal;
    }
    
    
    
     /*METODO PARA RECUPERAR CONTRASEÑA Y VALIDAR EMAIL */
    public void validarEmail() {
        try {

            Map<String, String> params;
            FacesContext fc = FacesContext.getCurrentInstance();
            params = fc.getExternalContext().getRequestParameterMap();
            this.correo = params.get("email");
            Usuario u = usuarioFacade.validarEmail(correo);
            RequestContext rc = RequestContext.getCurrentInstance();

            if (u.getEmail() != null) {
                String nuevaClave = "" + (int) (Math.random() * 1000000);
                u.setClave(nuevaClave);
                usuarioFacade.edit(u);
                correo enviaCorreo = new correo();
                enviaCorreo.sendClaves(u.getEmail(), u.getNombres() + " " + u.getApellidos(), u.getEmail(), u.getClave());

                rc.execute("swal('Usuario !','Se envio su clave al correo electronico ingresado', 'success');");
            } else {
                rc.execute("swal('Usuario !','correo electronico ingresado no existe', 'warning');");
            }

        } catch (Exception e) {
        }

    }

    
    
    /*METODOS DATOS DE SESION */
    
    public Integer idUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getIdUsuario();
    }
    
    public String nombreUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getNombres();
    }
    
     public String apellidoUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getApellidos();
    }
     
     public String docUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getDocumento();
    } 
     
     public String direccionUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getDireccion();
    }
     
     public String celUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getCel();
    }
     
     public String telUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getTelefonoFijo();
    }
     
    public String emailUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getEmail();
    }
    
     public String diseñoUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getDisenioCamiseta();
    }
     
      public String claveUsuarioConectado() {
        FacesContext contex = FacesContext.getCurrentInstance();
        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
        return user.getClave();
    }
     
//    public List<Facturas> facturasUsuarioConectado <>() {
//        FacesContext contex = FacesContext.getCurrentInstance();
//        Usuario user = (Usuario) contex.getExternalContext().getSessionMap().get("usuarioLog");
//        return user.getFacturaList();
//    }
}
