package ttps.spring.DAOS;

import java.util.List;

import ttps.spring.model.*;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public boolean existeUsuario(String numeroAlu);

	public Usuario recuperarUsuario(String usuario);
	
	public List<Cartelera> obtenerCartelerasPorSuscripcion();
	
	public List<Cartelera> obtenerMisCarteleras();
	
	public String obtenerMiPerfil();

	public boolean existePorNombre(String nombre);

	public boolean existePorNombreUsuario(String usuario);

	public Usuario encontrarPorToken(String token);

}
