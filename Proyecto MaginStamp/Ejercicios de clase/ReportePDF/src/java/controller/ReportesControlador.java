/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import entities.Producto;
import entities.Total;
import facade.ProductoFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "reportesControlador")
@SessionScoped
public class ReportesControlador implements Serializable {

    /**
     * Creates a new instance of ReportesControlador
     */
    public ReportesControlador() {
    }
    JasperPrint jasperPrint;
    @EJB
    ProductoFacade productoFacade;
    
    private Producto producto;
    private Total total;
    private List<Total> listaTotal;
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Total getTotal() {
        return total;
    }
    
    public void setTotal(Total total) {
        this.total = total;
    }
    
    public List<Total> getListaTotal() {
        return listaTotal;
    }
    
    public void setListaTotal(List<Total> listaTotal) {
        this.listaTotal = listaTotal;
    }
    
    public void listaTotales() {
        listaTotal = new ArrayList<>();
        List<Object[]> lista = productoFacade.calcularTotal();
        for (Object[] objects : lista) {
            total = new Total();
            total.setIdProducto(Integer.parseInt(objects[0].toString()));
            total.setProducto(objects[1].toString());
            total.setTotal(Integer.parseInt(objects[2].toString()));
            listaTotal.add(total);
        }
    }
    
    public void reporte(ActionEvent ae) throws JRException, IOException {
        listaTotales();
        JRBeanCollectionDataSource origen = new JRBeanCollectionDataSource(listaTotal);
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        jasperPrint = JasperFillManager.fillReport(ruta + "//NewReport.jasper", new HashMap(), origen);
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.addHeader("Content-disposition", "attachment; filename=reporte.pdf");
        ServletOutputStream sos = hsr.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, sos);
        FacesContext.getCurrentInstance().responseComplete();
    }
}
