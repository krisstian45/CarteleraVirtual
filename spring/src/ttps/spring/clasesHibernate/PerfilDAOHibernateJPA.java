package ttps.spring.clasesHibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class PerfilDAOHibernateJPA extends GenericDAOHibernateJPA<Perfil> implements PerfilDAO {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public PerfilDAOHibernateJPA() {
		super(Perfil.class);
	}

	@Override
	public boolean existePorNombre(String tipoPerfil) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Usuario.class).getSimpleName() + " e where tipoPerfil =?1");
		consulta.setParameter(1, tipoPerfil);
		boolean result = false;
		if (!consulta.getResultList().isEmpty()) {
			result = true;
		}
		return result;
	}

	

}
