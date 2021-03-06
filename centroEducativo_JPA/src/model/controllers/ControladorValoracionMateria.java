package model.controllers;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
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
	 * M??todo para buscar si existe un registro con un estudiante, profesor, materia determinados
	 * @return
	 */
	public ValoracionMateria findByAlumnoAndProfesorAndMateria (int idEstudiante, int idProfesor, int idMateria) {
		ValoracionMateria v = null;
		
		try {
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where idEstudiante=? and idProfesor=? and idMateria= ?", ValoracionMateria.class);
		q.setParameter(1, idEstudiante);
		q.setParameter(2, idProfesor);
		q.setParameter(3, idMateria);
		v = (ValoracionMateria) q.getSingleResult();
		em.close();
		}
		catch (NoResultException nrEX) {
			
		}
		return v;		
	}	
	
	/**
	 * 
	 * @param idMateria
	 * @param idProfesor
	 * @param Nota
	 * @return
	 */
	public List<Estudiante> findByMateriaAndProfesorAndNota(int idMateria, int idProfesor, float valoracion) {

		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("SELECT e.* FROM estudiante e, valoracionmateria v where e.id = v.idEstudiante and idProfesor = ? and idMateria = ? and valoracion = ?", Estudiante.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idMateria);
		q.setParameter(3, valoracion);
		
		List<Estudiante> lista = (List<Estudiante>) q.getResultList();
		em.close();
		return lista;

	}
	
	/**
	 * 
	 * @param idMateria
	 * @param idProfesor
	 * @param valoracion
	 * @return
	 */
	public List<Estudiante> findEstudiantesNotIn(int idMateria, int idProfesor, float valoracion) {

		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("select * from estudiante E left join (select idEstudiante from valoracionmateria where idProfesor=? and idMateria=? and valoracion=?) T on E.id=T.idEstudiante where T.idEstudiante is null", Estudiante.class);
		q.setParameter(1, idProfesor);
		q.setParameter(2, idMateria);
		q.setParameter(3, valoracion);
		
		List<Estudiante> lista = (List<Estudiante>) q.getResultList();
		em.close();
		return lista;

	}
	
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
