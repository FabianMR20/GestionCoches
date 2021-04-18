package controladoresypaneles.venta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Venta;



public class ControladorVenta {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorVenta instance = null;
	//En principio la conexión será nula
private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionCoches"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorVenta getInstance () {
		if (instance == null) {
			instance = new ControladorVenta();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorVenta() {
	}
	
	
	public Venta find(int id) {
		Venta c = null;
		EntityManager em = factory.createEntityManager();
		c = (Venta) em.find(Venta.class, id);
		em.close();
		return c;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Venta findPrimero () {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id limit 1", Venta.class);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findUltimo () {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id desc limit 1", Venta.class);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findSiguiente (int idActual) {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id > ? order by id limit 1", Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Venta findAnterior (int idActual) {
		Venta c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id < ? order by id desc limit 1", Venta.class);
		q.setParameter(1, idActual);
		c = (Venta) q.getSingleResult();
		em.close();
		
		return c;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Venta f) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (f.getId() == 0) {
				em.persist(f);
			}
			else {
				em.merge(f);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Venta f) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}

	
	/**
	 * 
	 * @return
	 */
	public List<Venta> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM venta", Venta.class);
		
		List<Venta> list = (List<Venta>) q.getResultList();
		em.close();
		return list;
	}
}
