/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sena.entidades.Personalizado;

/**
 *
 * @author User
 */
@Stateless
public class PersonalizadoFacade extends AbstractFacade<Personalizado> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalizadoFacade() {
        super(Personalizado.class);
    }
    
}
