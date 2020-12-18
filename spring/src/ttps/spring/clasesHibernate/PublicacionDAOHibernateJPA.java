package ttps.spring.clasesHibernate;

import java.util.List;
import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class PublicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO {
	public PublicacionDAOHibernateJPA() {
		super(Publicacion.class);
	}

	@Override
	public List<Comentario> obtenerComentarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtenerDueño() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cartelera obtenerCartelera() {
		// TODO Auto-generated method stub
		return null;
	}
}
