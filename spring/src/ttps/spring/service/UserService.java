package ttps.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.CarteleraDAO;
import ttps.spring.DAOS.UsuarioDAO;
import ttps.spring.DTO.UsuarioDTO;
import ttps.spring.DTO.UsuarioLoginDTO;
import ttps.spring.model.Cartelera;
import ttps.spring.model.Usuario;

@Service
@Transactional
public class UserService {
	@Autowired
	UsuarioDAO user;

	@Autowired
	CarteleraDAO carteleraDAO;

	public List<Usuario> findAllUsers() {
		return user.listar();

	}

	public UsuarioLoginDTO validar(UsuarioDTO usuarioDTO) {
		Usuario current = user.recuperarUsuario(usuarioDTO.getUsuario());
		UsuarioLoginDTO back = new UsuarioLoginDTO();
		if (current == null) {
			back.setToken("false");
			back.setUsuario("nombre de usuario erroneo");
			return back;
		} else if (!current.getContra().equals(usuarioDTO.getContra())) {
			back.setToken("false");
			back.setUsuario("contrasenia de usuario no coincide");
			return back;
		}
		UsuarioLoginDTO userBack = new UsuarioLoginDTO();
		current.setToken("token");
		user.actualizar(current);
		userBack.setId(current.getId());
		userBack.setNombre(current.getNombre());
		userBack.setUsuario(current.getUsuario());
		userBack.setToken(current.getToken());
		userBack.setPerfil(current.getPerfil().getTipoPerfil());
		return userBack;
	}

	public Usuario findById(long id) {
		return user.encontrarPorId(id);
	}

	public void updateUser(Usuario currentUser) {
		user.actualizar(currentUser);
	}

	public void saveUser(Usuario user2) {
		user.persistir(user2);
	}

	public boolean isUserExist(Usuario user2) {
		return user.existePorNombreUsuario(user2.getUsuario());
	}

	public boolean logout(long id, String token) {
		Usuario currentUser = this.findById(id);
		Boolean back = false;
		if (currentUser != null) {
			String currentToken = currentUser.getToken();
			if (currentToken.equals(token)) {
				back = true;
				currentUser.setToken("");
				user.actualizar(currentUser);
			}
		}
		return back;
	}

	public boolean addCartelera(long id, String token) {
		// TODO Auto-generated method stub
		Usuario currentUser = user.encontrarPorToken(token);
		Cartelera currentCartelera = carteleraDAO.encontrarPorId(id);
		currentUser.setCartelerasDeInteres(currentCartelera);
		user.actualizar(currentUser);
		return true;
	}

	public boolean addPublicador() {
		// TODO Auto-generated method stub
		Usuario currentUser = user.encontrarPorId(6);
		Cartelera currentCartelera = carteleraDAO.encontrarPorId(3);
		currentUser.setCartelerasDePublicadoresAcceso(currentCartelera);
		user.actualizar(currentUser);
		return true;
	}
}
