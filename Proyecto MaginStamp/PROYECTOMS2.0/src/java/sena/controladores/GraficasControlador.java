
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;
import sena.facades.CotizacionFacade;
import sena.facades.UsuarioFacade;

/**
 *
 * @author molderos
 */
@ManagedBean
public class GraficasControlador implements Serializable {      

 
//    private PieChartModel pieModel1;
    private PieChartModel pieModel2;

    @PostConstruct
    public void init() {
        createPieModels();
    }
    
    @EJB
    UsuarioFacade usuarioFacade;
//    CotizacionFacade cotizacionFacade;
  
 
//    public PieChartModel getPieModel1() {
//        return pieModel1;
//    }
    
     public PieChartModel getPieModel2() {
        return pieModel2;
    }

     
    private void createPieModels() {
//        createPieModel1();
        createPieModel2();
    }
    
//    private void createPieModel1() {
//        pieModel1 = new PieChartModel();
//        List<Object[]> listaCotizacion = cotizacionFacade.cotizacionesMes();
//
//        for (Object[] lista1 : listaCotizacion) {
//            pieModel1.set(lista1[0].toString(), Integer.parseInt(lista1[1].toString()));
//        }
//        pieModel1.setTitle("Cotizaciones");
//        pieModel1.setLegendPosition("e");
//        pieModel1.setShowDataLabels(true);
//    }  
    
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
        List<Object[]> lista = usuarioFacade.registrosMes();

        for (Object[] lista1 : lista) {
            pieModel2.set(lista1[0].toString(), Integer.parseInt(lista1[1].toString()));
        }
        pieModel2.setTitle("Usuarios Registrados");
        pieModel2.setLegendPosition("w");
        pieModel2.setShowDataLabels(true);
    }
}


