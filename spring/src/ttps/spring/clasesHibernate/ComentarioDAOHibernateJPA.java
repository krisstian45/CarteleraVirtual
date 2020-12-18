package ttps.spring.clasesHibernate;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO{
	public ComentarioDAOHibernateJPA() {
		super(Comentario.class);
	}

	@Override
	public Usuario obtenerDueño() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Publicacion obtenerPublicacion() {
		// TODO Auto-generated method stub
		return null;
	}
}
