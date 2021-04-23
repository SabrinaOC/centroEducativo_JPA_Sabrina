package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Tipologiasexo;





public class ControladorTipologiaSexo {

	private static ControladorTipologiaSexo instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativo_JPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipologiaSexo getInstance () {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorTipologiaSexo() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findPrimero () {
		Tipologiasexo s = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id limit 1", Tipologiasexo.class);
		s = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return s;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findUltimo () {
		Tipologiasexo s = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id desc limit 1", Tipologiasexo.class);
		s = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return s;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findSiguiente (int idActual) {
		Tipologiasexo s = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id > ? order by id limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		s = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return s;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findAnterior (int idActual) {
		Tipologiasexo s = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id < ? order by id desc limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		s = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return s;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Tipologiasexo s) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (s.getId() == 0) {
				em.persist(s);
			}
			else {
				em.merge(s);
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
	public void borrar(Tipologiasexo s) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(s)) {
		    s = em.merge(s);
		}
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método para meter todos los sexos en una lista y usarlo en el jcb
	 * @return
	 */
	public List<Tipologiasexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
		
		List<Tipologiasexo> list = (List<Tipologiasexo>) q.getResultList();
		em.close();
		return list;
	}	

	
	

}
