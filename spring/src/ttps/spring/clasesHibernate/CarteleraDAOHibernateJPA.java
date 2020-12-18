package ttps.spring.clasesHibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {
	private EntityManager entityManager;
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public CarteleraDAOHibernateJPA() {
		super(Cartelera.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Cartelera> listarDocente(Long id) {		
		Query consulta = this.getEntityManager().createQuery("select e from " + Cartelera.class.getSimpleName() + " e where dueño_id=?1 ");
		consulta.setParameter(1, id);
		List<Cartelera> resultado = (List<Cartelera>) consulta.getResultList();
		Query consulta2 = this.getEntityManager().createQuery("select e from " + Cartelera.class.getSimpleName() + " e where dueño_id <> ?1 ");
		consulta2.setParameter(1, id);
		resultado.addAll((List<Cartelera>) consulta2.getResultList());
		return resultado;
	}
	@Override
	public List<Usuario> obtenerSuscriptos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> obtenerPublicaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> obtenerTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerDueño() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartelera> listarCartelerasOwner(Long id) {
		Query consulta = this.getEntityManager().createQuery("select e from " + Cartelera.class.getSimpleName() + " e where dueño_id=?1 ");
		consulta.setParameter(1, id);
		@SuppressWarnings("unchecked")
		List<Cartelera> resultado = (List<Cartelera>) consulta.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> listarCartelerasNoOwner(Long id) {
		Query consulta = this.getEntityManager().createQuery("select e from " + Cartelera.class.getSimpleName() + " e where dueño_id <> ?1 ");
		consulta.setParameter(1, id);
		@SuppressWarnings("unchecked")
		List<Cartelera> resultado = (List<Cartelera>) consulta.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> listarCartelerasDeInteres(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
