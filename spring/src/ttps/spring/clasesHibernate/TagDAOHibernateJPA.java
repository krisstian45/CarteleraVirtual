package ttps.spring.clasesHibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class TagDAOHibernateJPA extends GenericDAOHibernateJPA<Tag> implements TagDAO {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public TagDAOHibernateJPA() {
		super(Tag.class);
	}

	@Override
	public boolean existePorNombre(String nombreTag) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Tag.class).getSimpleName() + " e where nombreTag =?1");
		consulta.setParameter(1, nombreTag);
		boolean result = false;
		if (!consulta.getResultList().isEmpty()) {
			result = true;
		}
		return result;
	}
}
