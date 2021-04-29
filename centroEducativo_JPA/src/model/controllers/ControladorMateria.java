package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;





public class ControladorMateria {

	private static ControladorMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativo_JPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorMateria getInstance () {
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorMateria() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Materia findPrimero () {
		Materia m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id limit 1", Materia.class);
		m = (Materia) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Materia findUltimo () {
		Materia m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia order by id desc limit 1", Materia.class);
		m = (Materia) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Materia findSiguiente (int idActual) {
		Materia m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id > ? order by id limit 1", Materia.class);
		q.setParameter(1, idActual);
		m = (Materia) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Materia findAnterior (int idActual) {
		Materia m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.materia where id < ? order by id desc limit 1", Materia.class);
		q.setParameter(1, idActual);
		m = (Materia) q.getSingleResult();
		em.close();
		
		return m;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Materia m) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (m.getId() == 0) {
				em.persist(m);
			}
			else {
				em.merge(m);
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
	public void borrar(Materia m) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin(); 
		if (!em.contains(m)) {
		    m = em.merge(m);
		}
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * Método para meter todos las materias exitentes en una lista y usarlo en el jcb
	 * @return
	 */
	public List<Materia> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		List<Materia> list = (List<Materia>) q.getResultList();
		em.close();
		return list;
	}	
	

}
