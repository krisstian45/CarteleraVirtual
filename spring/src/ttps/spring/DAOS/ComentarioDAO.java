package ttps.spring.DAOS;

import ttps.spring.model.*;

public interface ComentarioDAO extends GenericDAO<Comentario> {
	public Usuario obtenerDue�o();

	public Publicacion obtenerPublicacion();
}
