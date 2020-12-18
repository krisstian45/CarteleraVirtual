package ttps.spring.clasesHibernate;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class NotificacionDAOHibernateJPA extends GenericDAOHibernateJPA<Notificacion> implements NotificacionDAO {
	public NotificacionDAOHibernateJPA() {
		super(Notificacion.class);
	}

	@Override
	public boolean existePorNombre(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}
}
