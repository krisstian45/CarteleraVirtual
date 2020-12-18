package ttps.spring.clasesHibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class PermisoDAOHibernateJPA extends GenericDAOHibernateJPA<Permiso> implements PermisoDAO {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public PermisoDAOHibernateJPA() {
		super(Permiso.class);
	}

	@Override
	public boolean existePorNombre(String tipoPermiso) {
		// TODO Auto-generated method stub
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Permiso.class).getSimpleName() + " e where tipoPermiso =?1");
		consulta.setParameter(1, tipoPermiso);
		boolean result = false;
		if (!consulta.getResultList().isEmpty()) {
			result = true;
		}
		return result;
	}
}
