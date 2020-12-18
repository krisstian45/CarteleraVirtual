package ttps.spring.clasesHibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;
import ttps.spring.DAOS.*;

@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	/*
	 * public Usuario recuperarUsuario(String usuario) { Query consulta =
	 * EMF.getEMF().createQuery("from Usuario where usuario =?1");
	 * consulta.setParameter(1, usuario); Usuario resultado = (Usuario)
	 * consulta.getSingleResult(); return resultado; }
	 * 
	 * public boolean existeUsuario(String numeroAlu) { Query consulta =
	 * EMF.getEMF().createQuery("from Usuario where numeroAlumno =?1");
	 * consulta.setParameter(1, numeroAlu); Usuario resultado = (Usuario)
	 * consulta.getSingleResult(); boolean result = false; if (resultado != null) {
	 * result = true; } return result; }
	 */

	@Override
	public List<Cartelera> obtenerCartelerasPorSuscripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartelera> obtenerMisCarteleras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenerMiPerfil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeUsuario(String numeroAlu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario recuperarUsuario(String usuario) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Usuario.class).getSimpleName() + " e where usuario =?1");
		consulta.setParameter(1, usuario);
		System.out.println(consulta.getResultList());
		if (!consulta.getResultList().isEmpty()) {
			return (Usuario) consulta.getSingleResult();
		}
		@SuppressWarnings("unused")
		Usuario back = new Usuario();
		return back = null;
	}

	@Override
	public boolean existePorNombre(String nombre) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Usuario.class).getSimpleName() + " e where nombre =?1");
		consulta.setParameter(1, nombre);
		boolean result = false;
		if (!consulta.getResultList().isEmpty()) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean existePorNombreUsuario(String usuario) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Usuario.class).getSimpleName() + " e where usuario =?1");
		consulta.setParameter(1, usuario);
		boolean result = false;
		if (!consulta.getResultList().isEmpty()) {
			result = true;
		}
		return result;
	}

	@Override
	public Usuario encontrarPorToken(String token) {
		Query consulta = this.getEntityManager()
				.createQuery("select e from " + (Usuario.class).getSimpleName() + " e where token =?1");
		consulta.setParameter(1, token);
		if (!consulta.getResultList().isEmpty()) {
			return (Usuario) consulta.getSingleResult();
		}
		@SuppressWarnings("unused")
		Usuario back = new Usuario();
		return back = null;
	}
}
