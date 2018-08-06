/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Empleado;
import Entidades.Soportes;
import Facades.EmpleadoFacade;
import Facades.SoportesFacade;
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
 * @author JohanOrtiz
 */
@Named(value = "soportesControlador")
@SessionScoped
public class SoportesControlador implements Serializable {

    public SoportesControlador() {
    }

    @PostConstruct
    public void init() {

        soporte = new Soportes();
        empleado = new Empleado();
        listaSoportes = soportesFacade.buscarTodo();
    }
    @EJB
    SoportesFacade soportesFacade;
    @EJB
    EmpleadoFacade empleadoFacade;

    private Soportes soporte;
    private Empleado empleado;
    private List<Soportes> listaSoportes;

    public Soportes getSoporte() {
        return soporte;
    }

    public void setSoporte(Soportes soporte) {
        this.soporte = soporte;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Soportes> getListaSoportes() {
        listaSoportes = soportesFacade.buscarTodo();
        return listaSoportes;
    }

    public void setListaSoportes(List<Soportes> listaSoportes) {
        this.listaSoportes = listaSoportes;
    }
    private Part file;
    private String nombre;
    private String pathReal;

    private Part file2;
    private String nombre2;
    private String pathReal2;

    private Part file3;
    private String nombre3;
    private String pathReal3;

    private Part file4;
    private String nombre4;
    private String pathReal4;

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

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getPathReal2() {
        return pathReal2;
    }

    public void setPathReal2(String pathReal2) {
        this.pathReal2 = pathReal2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getPathReal3() {
        return pathReal3;
    }

    public void setPathReal3(String pathReal3) {
        this.pathReal3 = pathReal3;
    }

    public Part getFile4() {
        return file4;
    }

    public void setFile4(Part file4) {
        this.file4 = file4;
    }

    public String getNombre4() {
        return nombre4;
    }

    public void setNombre4(String nombre4) {
        this.nombre4 = nombre4;
    }

    public String getPathReal4() {
        return pathReal4;
    }

    public void setPathReal4(String pathReal4) {
        this.pathReal4 = pathReal4;
    }

    public String subir() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre = file.getSubmittedFileName();
            pathReal = "/CargaArchivos1/Archivos/" + nombre;
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

    public String subir2() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre2 = file2.getSubmittedFileName();
            pathReal2 = "/CargaArchivos1/Archivos/" + nombre2;
            path = path + this.nombre2;
            InputStream in = file2.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal2;
    }

    public String subir3() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre3= file3.getSubmittedFileName();
            pathReal3 = "/CargaArchivos1/Archivos/" + nombre3;
            path = path + this.nombre3;
            InputStream in = file3.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal3;
    }
    public String subir4() {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("Archivos");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\Archivos\\";
        try {
            this.nombre4 = file4.getSubmittedFileName();
            pathReal4 = "/CargaArchivos1/Archivos/" + nombre4;
            path = path + this.nombre4;
            InputStream in = file4.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pathReal4;
    }
    public void registrar() {
        soporte.setIdsoportes(00);
        soporte.setCedula(subir());
        soporte.setDiplomaPregrado(subir2());
        soporte.setExperiencia1(subir3());
        soporte.setExperiencia2(subir4());
        soporte.setEmpleadoidEmpleado(empleado);
        soportesFacade.registrar(soporte);
        soporte = new Soportes();
        this.getListaSoportes();
    }
}
