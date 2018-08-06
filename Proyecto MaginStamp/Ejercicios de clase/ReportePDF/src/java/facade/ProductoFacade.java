/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Producto;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author NelsonHernan
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "ReportePDFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }

    public List<Object[]> calcularTotal() {
        Query query = em.createNativeQuery("SELECT producto.id_producto, producto.producto, producto.cantidad * producto.precio AS Total FROM producto");
        //List<Object[]>  result=em.createQuery("SELECT p.idProducto,p.producto,(p.cantidad*p.precio) as Total  FROM  Producto p").getResultList();
        List<Object[]> result = query.getResultList();
        /*for(Object[] object : result) {
            System.out.println("Codigo: "+object[0]+ ", Nombre: "+object[1]+ ", Total: "+object[2]);
        }*/
        return result;
    }
}
