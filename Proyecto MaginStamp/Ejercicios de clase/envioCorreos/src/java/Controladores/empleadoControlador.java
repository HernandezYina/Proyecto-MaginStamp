/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Empleado;
import Facades.EmpleadoFacade;
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
@Named(value = "empleadoControlador")
@SessionScoped
public class empleadoControlador implements Serializable {

    /**
     * Creates a new instance of empleadoControlador
     */
    public empleadoControlador() {
    }
    
    @PostConstruct
    public void init (){
       empleado = new Empleado();
       listaEmpleado = empleadoFacade.findAll();
    }
    
    @EJB
    EmpleadoFacade empleadoFacade;

    private Empleado empleado;
    private List<Empleado> listaEmpleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
    
    public void create() {
        empleado.setIdEmpleado(00);
        empleadoFacade.create(empleado);
        empleado = new Empleado();
    }

    public void remove(Empleado objEmpleado) {
        empleadoFacade.remove(objEmpleado);
        empleado = new Empleado();
    }

    public String edit(Empleado objEmpleado) {
        empleado = objEmpleado;
        return "editarEmpleado";
    }

    public void edit() {
        empleadoFacade.edit(empleado);
    }
}
