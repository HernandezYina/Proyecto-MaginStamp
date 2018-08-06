/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Empleado;
import Entidades.Mensaje;
import Facades.EmpleadoFacade;
import Facades.MensajeFacade;
import correo.envioCorreo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author molderos
 */
@Named(value = "mensajeControlador")
@SessionScoped
public class mensajeControlador implements Serializable {

    /**
     * Creates a new instance of mensajeControlador
     */
    public mensajeControlador() {
    }
    private String Clave; 

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }   
   
    @PostConstruct
    public void init (){
       mensaje = new Mensaje();
       empleado = new Empleado();
      
    }
    
    @EJB
    MensajeFacade mensajeFacade;
    
    @EJB
    EmpleadoFacade empleadoFacade;

    private Mensaje mensaje;
    private Empleado empleado;
    
       public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public List<Empleado> listarEmpleado(){
        return empleadoFacade.findAll();
    }
   public List<Mensaje> listarMensaje(){
        return mensajeFacade.findAll();
    }
    
    public void create() {
        try{
            Empleado destinatario = new Empleado();
            destinatario = empleadoFacade.find(empleado.getIdEmpleado());
           envioCorreo.send(mensaje.getCorreo(), Clave,destinatario.getMail(), mensaje.getAsunto(), mensaje.getMensaje());
           mensaje.setIdMensaje(00);
           mensaje.setIdEmpleado(empleado);
           mensaje.setDestinatario(destinatario.getMail());
           mensajeFacade.create(mensaje);
           empleado = new Empleado();
            System.out.println("Enviado");
        }catch (Exception e){
        System.out.println("error"+e.getMessage());
    }
        
    }


}
