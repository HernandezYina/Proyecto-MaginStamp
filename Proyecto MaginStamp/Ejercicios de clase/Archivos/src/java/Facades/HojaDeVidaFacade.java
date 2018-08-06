/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entidades.HojaDeVida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
@Stateless
public class HojaDeVidaFacade extends AbstractFacade<HojaDeVida> {

    @PersistenceContext(unitName = "ArchivosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojaDeVidaFacade() {
        super(HojaDeVida.class);
    }
     public String cargaDatos(String archivo, String tabla){
        Query query=em.createNativeQuery("LOAD DATA LOCAL INFILE '"+archivo+"' REPLACE INTO TABLE "+tabla+" FIELDS TERMINATED BY ';' "
                + "ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        
        int resultado=query.executeUpdate();
        String mensaje=resultado+ "filas afectadas";
        return mensaje;
    }
}
