package ttps.spring.DAOS;

import ttps.spring.model.*;

public interface NotificacionDAO extends GenericDAO<Notificacion> {

	boolean existePorNombre(String nombre);

}
