/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Producto;
import entities.Total;
import facade.ProductoFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author NelsonHernan
 */
@Named(value = "reporteControlador")
@SessionScoped
public class ReporteControlador implements Serializable {
@EJB
ProductoFacade prodructoFacade;
private List<Producto> listaProducto;
private List<Object[]> listaTotal;
private List<Total> listaTotales;

    public List<Total> getListaTotales() {
        return listaTotales;
    }

    public void setListaTotales(List<Total> listaTotales) {
        this.listaTotales = listaTotales;
    }

JasperPrint jasperPrint;
@PostConstruct
public void init(){
      listaFinal();
        
    
     }
public ReporteControlador() {
    }

    public List<Producto> getListaProdructo() {
        listaProducto=prodructoFacade.findAll();
        return listaProducto;
    }

    public void setListaProdructo(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    
   public void PDF(ActionEvent actionEvent) throws JRException, IOException{
      JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaProducto);
        String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        jasperPrint=JasperFillManager.fillReport(ruta+"//reporteProducto.jasper", new HashMap(),beanCollectionDataSource);
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
       FacesContext.getCurrentInstance().responseComplete();;
       
   
   }
public void PDFJPQL(ActionEvent actionEvent) throws JRException, IOException{
    listaTotales=new ArrayList<>();
    listaTotal=prodructoFacade.calcularTotal();
    for (Object[] elemento : listaTotal) {
        Total tot=new Total();
        tot.setIdProducto(Integer.parseInt(elemento[0].toString()));
        tot.setNombre(elemento[1].toString());
        tot.setTotal(Long.parseLong(elemento[2].toString()));
        listaTotales.add(tot);
    }
   HashMap parametros=new HashMap();
    parametros.put("logo", "C:\\Users\\NelsonHernan.Lenovo-PC\\Documents\\NetBeansProjects\\ReportePDF\\web\\reportes\\cherry.jpg");
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaTotales);
        String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        jasperPrint=JasperFillManager.fillReport(ruta+"//reporte.jasper", parametros,beanCollectionDataSource);
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      httpServletResponse.addHeader("Content-disposition", "attachment; filename=reporteJoin.pdf");
      httpServletResponse.setContentType("application/pdf");
                httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
                httpServletResponse.setHeader("Cache-Control", "no-cache");
                httpServletResponse.setHeader("Pragma", "no-cache"); 
      ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
       FacesContext.getCurrentInstance().responseComplete();
       
   
   }
public void reporteGrafico(ActionEvent actionEvent) throws JRException, IOException
{
    
   HashMap parametros=new HashMap();
    parametros.put("logo", "C:\\Users\\NelsonHernan.Lenovo-PC\\Documents\\NetBeansProjects\\ReportePDF\\web\\reportes\\cherry.jpg");
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaTotales);
        String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        jasperPrint=JasperFillManager.fillReport(ruta+"//reprotegrafico.jasper", parametros,beanCollectionDataSource);
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
      httpServletResponse.setContentType("application/pdf");
                httpServletResponse.setHeader("Content-Disposition", "attachment; filename=reporteGrafico.pdf");
                httpServletResponse.setHeader("Cache-Control", "no-cache");
                httpServletResponse.setHeader("Pragma", "no-cache"); 
      ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
       FacesContext.getCurrentInstance().responseComplete();
    
}
    public List<Object[]> getListaTotal() {
    listaTotal=prodructoFacade.calcularTotal();
        return listaTotal;
    }
    
    public void setListaTotal(List<Object[]> listaTotal) {
        
        this.listaTotal = listaTotal;
    }
    public void listaFinal(){
    listaTotales=new ArrayList<>();
    listaTotal=prodructoFacade.calcularTotal();
    for (Object[] elemento : listaTotal) {
        Total tot=new Total();
        tot.setIdProducto(Integer.parseInt(elemento[0].toString()));
        tot.setNombre(elemento[1].toString());
        tot.setTotal(Long.parseLong(elemento[2].toString()));
        listaTotales.add(tot);
    }
    }
}
