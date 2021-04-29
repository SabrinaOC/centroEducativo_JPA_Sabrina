package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Profesor;
import model.entities.ValoracionMateria;







public class ControladorValoracionMateria {

	private static ControladorValoracionMateria instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativo_JPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstance () {
		if (instance == null) {
			instance = new ControladorValoracionMateria();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorValoracionMateria() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findPrimero () {
		ValoracionMateria v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria order by id limit 1", ValoracionMateria.class);
		v = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return v;
	}
	

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findUltimo () {
		ValoracionMateria v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria order by id desc limit 1", ValoracionMateria.class);
		v = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return v;
	}
	

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findSiguiente (int idActual) {
		ValoracionMateria v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where id > ? order by id limit 1", ValoracionMateria.class);
		q.setParameter(1, idActual);
		v = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return v;
	}
	

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findAnterior (int idActual) {
		ValoracionMateria v = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where id < ? order by id desc limit 1", ValoracionMateria.class);
		q.setParameter(1, idActual);
		v = (ValoracionMateria) q.getSingleResult();
		em.close();
		
		return v;		
	}
	
	/**
	 * Método para buscar todos los alumnos que coinciden con un profesor y una materia determinada
	 * @return
	 */
	public List<ValoracionMateria> findAlumnosProfMaterias (int idProfesor, int idMateria) {
		//ValoracionMateria v = null;
		List<ValoracionMateria> todos;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where idProfesor=? and idMateria= ?", ValoracionMateria.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idMateria);
		todos = (List<ValoracionMateria>) q.getResultList();
		em.close();
		
		return todos;		
	}
	
	
	/**
	 * Método para meter todos los profesores en una lista y usarlo en el jcb
	 * @return
	 */
//	public List<Profesor> findAll () {
//		EntityManager em = factory.createEntityManager();
//		
//		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
//		
//		List<Profesor> list = (List<Profesor>) q.getResultList();
//		em.close();
//		return list;
//	}	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (ValoracionMateria v) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (v.getId() == 0) {
				em.persist(v);
			}
			else {
				em.merge(v);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}



	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(ValoracionMateria v) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(v)) {
		    v = em.merge(v);
		}
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}

	
	

}
