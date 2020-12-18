package ttps.spring.DAOS;

import java.util.List;

import ttps.spring.model.*;


public interface PublicacionDAO extends GenericDAO<Publicacion> {
	public List<Comentario> obtenerComentarios();
	
	public Usuario obtenerDueño();
	
	public Cartelera obtenerCartelera();
}
