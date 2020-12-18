package ttps.spring.clasesHibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import ttps.spring.DAOS.*;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	private EntityManager entityManager;
	protected Class<T> persistentClass;

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public GenericDAOHibernateJPA(Class<T> string) {
		setPersistentClass(string);
	}

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public T persistir(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public void borrar(T entity) {
		this.getEntityManager().remove(entity);
	}
	
	@Override
	public T actualizar(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}
	
	@Override
	public void borrarPorId(Serializable id) {
		
			T entity = (T) recuperar(id);
			this.getEntityManager().remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T recuperar(Serializable id) {
		return this.getEntityManager().find((Class<T>) (this.getEntityManager().getClass()), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(Serializable id) {
		// TODO Auto-generated method stub
		T entity =this.getEntityManager().find((Class<T>) (this.getEntityManager().getClass()), id);
		boolean result = false;
		if (entity != null) {
			result = true;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {		
		Query consulta = this.getEntityManager().createQuery("select e from " + getPersistentClass().getSimpleName() + " e ");
		List<T> resultado = (List<T>) consulta.getResultList();
		System.out.println((List<T>) resultado);
		return resultado;
	}

	@Override
	public void borrarTodos() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T encontrarPorId(long id) {
		T entity =this.getEntityManager().find((Class<T>) (this.getPersistentClass()), id);
		return entity;
	}

	@Override
	public List<T> recuperarTodos(String columnOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> recuperarTodosOrdenados(String columnOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public T actualizar(T entity) {
		EntityManager em = EMF.getEMF();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		T entityR = em.merge(entity);
		etx.commit();
		em.close();
		return entityR;
	}*/

	/*@Override
	public void borrar(T entity) {
		EntityManager em = EMF.getEMF();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		} finally {
			em.close();
		}
	}*/

	/*public void borrarPorId(Serializable id) {
		EntityManager em = EMF.getEMF();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			T entity = (T) recuperar(id);
			em.remove(!em.contains(entity) ? em.merge(entity) : entity);// muy importante
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e; // escribir en un log o mostrar un mensaje
		} finally {
			em.close();
		}
	}*/

	/*
	 * @Override public T persistir(T entity) { EntityManager em = EMF.getEMF();
	 * EntityTransaction tx = null; try { tx = em.getTransaction(); tx.begin();
	 * em.persist(entity); tx.commit();
	 * 
	 * } catch (RuntimeException e) { // TODO: handle exception if (tx != null &&
	 * tx.isActive()) tx.rollback(); throw e; // escribir en un log o mostrar
	 * mensaje } finally { em.close(); } return entity; }
	 */

	/*@Override
	public void borrarTodos() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Query connsulta = EMF.getEMF().createQuery("TRUNCATE TABLE " + getPersistentClass().getSimpleName());
	}

	@Override
	public List<T> listar() {
		Query consulta = EMF.getEMF().createQuery("select e from " + getPersistentClass().getSimpleName() + " e ");
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}

	public List<T> recuperarTodos(String columnOrder) {
		Query consulta = EMF.getEMF()
				.createQuery("select e from " + getPersistentClass().getSimpleName() + " e order by	e." + columnOrder);
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}

	@Override
	public List<T> recuperarTodosOrdenados(String columnOrder) {
		Query consulta = EMF.getEMF()
				.createQuery("from " + getPersistentClass().getSimpleName() + " e order by  e." + columnOrder + " ASC");
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}

	@Override
	public T encontrarPorId(int id) {
		T entity = EMF.getEMF().find((Class<T>) this.getPersistentClass(), id);
		return entity;
	}

	@Override
	public boolean existe(Serializable id) {
		T entity = EMF.getEMF().find((Class<T>) this.getPersistentClass(), id);
		boolean result = false;
		if (entity != null) {
			result = true;
		}
		return result;
	}*/
}
