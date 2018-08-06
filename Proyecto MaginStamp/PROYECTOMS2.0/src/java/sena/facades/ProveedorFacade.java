/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sena.entidades.Proveedor;

/**
 *
 * @author User
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    public String cargaDatos(String archivo, String tabla){
        Query query=em.createNativeQuery("LOAD DATA LOCAL INFILE '"+archivo+"' REPLACE INTO TABLE "+tabla+" FIELDS TERMINATED BY ';' "
                + "ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        
        int resultado=query.executeUpdate();
        String mensaje=resultado+ "filas afectadas";
        return mensaje;
    }
    
}
