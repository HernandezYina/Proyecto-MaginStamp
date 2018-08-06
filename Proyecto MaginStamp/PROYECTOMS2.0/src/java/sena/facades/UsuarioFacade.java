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
import sena.entidades.Usuario;

/**
 *
 * @author User
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PROYECTOMSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    
    public Usuario iniciarsesion(Usuario usuariolog) {
        Usuario usuario = null;

        try {

            Query query = em.createQuery("select u from Usuario u where u.email=:email and u.clave=:clave");
            query.setParameter("email", usuariolog.getEmail());
            query.setParameter("clave", usuariolog.getClave());

            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }

        } catch (Exception e) {
            throw e;

        } finally {
            //em.close();
        }
        return usuario;
    }

    public String cargaDatos(String archivo, String tabla) {
        Query query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + archivo + "' REPLACE INTO TABLE " + tabla + " FIELDS TERMINATED BY ';' "
                + "ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");

        int resultado = query.executeUpdate();
        String mensaje = resultado + "filas afectadas";
        return mensaje;
    }

    
    
    
    
    public List<Object[]> registrosMes() {
        System.out.println("Prueba");
        Query Sql = em.createNativeQuery("SELECT MonthName(fechaRegistro) AS Mes, COUNT(*) AS registros, Year(fechaRegistro) AS anio FROM Usuario GROUP BY MONTH(fechaRegistro) ORDER BY fechaRegistro ASC;");
        List<Object[]> lista = Sql.getResultList();
        for (Object[] lista1 : lista) {
            System.out.println("fecha" + lista1[0].toString());
            String a = lista1[1].toString();
            System.out.println(a);
            System.out.println("Cantidad" + lista1[1]);   //+ a.substring(0, a.length() - 2));  para que funcionara con nuestra variable string y quitara los decimales
        }
        return lista;
    }
    
    
    
    public Usuario validarEmail(String email) {
        Usuario salida = new Usuario();
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
            q.setParameter("email", email);
            salida = (Usuario) q.getSingleResult();

            return salida;
        } catch (Exception e) {
        }
        return salida;
    }
}
