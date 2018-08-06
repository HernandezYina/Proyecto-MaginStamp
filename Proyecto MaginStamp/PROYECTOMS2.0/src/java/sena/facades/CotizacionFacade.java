/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sena.entidades.Cotizacion;

/**
 *
 * @author User
 */
@Stateless
public class CotizacionFacade extends AbstractFacade<Cotizacion> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CotizacionFacade() {
        super(Cotizacion.class);
    }
    
    public String cargaDatos(String archivo, String tabla){
        Query query=em.createNativeQuery("LOAD DATA LOCAL INFILE '"+archivo+"' REPLACE INTO TABLE "+tabla+" FIELDS TERMINATED BY ';' "
                + "ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        
        int resultado=query.executeUpdate();
        String mensaje=resultado+ "filas afectadas";
        return mensaje;
    }
    
    
    
    public List<Object[]> cotizacionesMes() {
        System.out.println("Prueba");
        Query Sql = em.createNativeQuery("SELECT MonthName(fecha) AS Mes, COUNT(*) AS cotizaciones, Year(fecha) AS anio FROM Cotizacion GROUP BY MONTH(fecha) ORDER BY fecha ASC;");
        List<Object[]> listaCotizacion = Sql.getResultList();
        for (Object[] lista1 : listaCotizacion) {
            System.out.println("fecha" + lista1[0].toString());
            String a = lista1[1].toString();
            System.out.println(a);
            System.out.println("Cantidad" + lista1[1]);   //+ a.substring(0, a.length() - 2));  para que funcionara con nuestra variable string y quitara los decimales
        }
        return listaCotizacion;
    }
}
