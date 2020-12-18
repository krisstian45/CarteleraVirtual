package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.UsuarioDTO;
import ttps.spring.DTO.UsuarioLoginDTO;
import ttps.spring.DTO.UsuarioLogoutDTO;
import ttps.spring.model.*;
import ttps.spring.service.UserService;

@RestController
public class UsuarioRestController {
	@Autowired
	UserService userService;

	// Recupero todos los usuarios
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUsers() {
		List<Usuario> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	}
	
	//login
	@RequestMapping(value = "/users/log_in/", method = RequestMethod.POST)
	public ResponseEntity<UsuarioLoginDTO> validarUsuario(@RequestBody UsuarioDTO user) {
		System.out.println("entre a validar usuario");
		UsuarioLoginDTO login=userService.validar(user);
		if (login.getToken() ==  "false" ) {
			System.out.println("Usuario no autorizado");
			return new ResponseEntity<UsuarioLoginDTO>(login,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<UsuarioLoginDTO>(login, HttpStatus.OK);
	}
	
	//logout
		@RequestMapping(value = "/users/log_out/", method = RequestMethod.POST)
		public ResponseEntity<UsuarioLogoutDTO> cerrarSesion(@RequestHeader("Authorization") String token,@RequestBody UsuarioLogoutDTO user) {
			System.out.println("entre a cerrar sesion");
			if (!userService.logout(user.getId(),token) ) {
				System.out.println("Usuario no autorizado error de token");
				return new ResponseEntity<UsuarioLogoutDTO>(HttpStatus.UNAUTHORIZED);
			}
			return new ResponseEntity<UsuarioLogoutDTO>(HttpStatus.OK);
		}

	// Recupero un usuario dado
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUser(@PathVariable("id") long id) {
		System.out.println("Obteniendo usuario con id " + id);
		Usuario user = userService.findById(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

	// Creo un usuario
	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Usuario user) {
		System.out.println("Creando el usuario " + user.getNombre());
		if (userService.isUserExist(user)) {
			System.out.println("Ya existe un usuario con nombre  " + user.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
		}
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	// Actualizo un usuario
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUser(@RequestHeader("Authorization") String token,@PathVariable("id") long id, @RequestBody Usuario user) {
		System.out.println("Actualizando el usuario " + id);
		Usuario currentUser = userService.findById(id);
		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		currentUser.setNombre(user.getNombre());
		userService.updateUser(currentUser);
		return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
	}
	
	// Actualizo un usuario
		@RequestMapping(value = "/users/suscribir/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Usuario> updateUserCartelera(@RequestHeader("Authorization") String token,@PathVariable("id") long id) {
			System.out.println("usuario se suscribe a la cartelera con id " + id);
			if (!userService.addCartelera(id,token)) {
				System.out.println("User with id " + id + " not found");
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		}
		
		@RequestMapping(value = "/users/publica/", method = RequestMethod.PUT)
		public ResponseEntity<Usuario> usuarioAddCarteleraForPublicador() {
			System.out.println("agrego una cartelara para que un publicador pueda publicar");
			if (!userService.addPublicador()) {
				System.out.println("User with id  not found");
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Usuario>(HttpStatus.OK);
		}
		
}