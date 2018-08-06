/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sena.entidades.Mensaje;

/**
 *
 * @author User
 */
@Stateless
public class MensajeFacade extends AbstractFacade<Mensaje> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajeFacade() {
        super(Mensaje.class);
    }
    
}
