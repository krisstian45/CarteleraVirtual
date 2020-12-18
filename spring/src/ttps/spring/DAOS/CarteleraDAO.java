package ttps.spring.DAOS;

import java.util.List;

import ttps.spring.model.*;

public interface CarteleraDAO extends GenericDAO<Cartelera> {
	public List<Usuario> obtenerSuscriptos();
	
	public List<Publicacion> obtenerPublicaciones();
	
	public List<Tag> obtenerTags();
	
	public Usuario obtenerDueño();

	public List<Cartelera> listarDocente(Long id);

	public List<Cartelera> listarCartelerasOwner(Long id);

	public List<Cartelera> listarCartelerasNoOwner(Long id);

	public List<Cartelera> listarCartelerasDeInteres(Long id);

}
