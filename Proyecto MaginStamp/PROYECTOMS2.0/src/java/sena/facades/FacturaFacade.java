/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sena.facades;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sena.entidades.Factura;
import sena.entidades.Usuario;

/**
 *
 * @author User
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
    //    mostrar listas por sesión
    public Integer idUsuarioLogueado() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog");
        return us.getIdUsuario();
    }

    public List<Factura> listaFacturasUsuario(List listaFacturaUs) {
        List<Factura> listaFaturaUs = new ArrayList<>();
        Query query = em.createQuery("SELECT m FROM Factura m WHERE m.usuarioIdUsuario.idUsuario = :var1");
        query.setParameter("var1", idUsuarioLogueado());
        listaFacturaUs = query.getResultList();
        return listaFacturaUs;
    }
}
