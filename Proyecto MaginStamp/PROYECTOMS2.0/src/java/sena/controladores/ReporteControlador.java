/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import java.sql.SQLException;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import sena.clases.ReporteCotizaciones;

/**
 *
 * @author User
 */
@Named(value = "reporteControlador")
@ViewScoped
public class ReporteControlador {

    /**
     * Creates a new instance of ReporteControlador
     */
    public ReporteControlador() {
    }
    
    //Metodo para invocar el reporte y enviarle los parametros si es que necesita
    public void verReporte() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        //Instancia hacia la clase reporteClientes        
        ReporteCotizaciones rCotizaciones = new ReporteCotizaciones();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Reportes/Cotizaciones.jasper");
       
        rCotizaciones.getReporte(ruta);        
        FacesContext.getCurrentInstance().responseComplete();               
    }
    
}
