package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Perfil;
import ttps.spring.service.PerfilService;

@RestController
public class PerfilRestController {
	@Autowired
	PerfilService perfilService;

	// Recupero todos los perfiles
	@RequestMapping(value = "/perfiles/", method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> listAllPerfiles() {
		List<Perfil> perfil = perfilService.findAllPerfiles();
		if (perfil.isEmpty()) {
			return new ResponseEntity<List<Perfil>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Perfil>>(perfil, HttpStatus.OK);
	}

	// Recupero un perfil dado
	@RequestMapping(value = "/perfiles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil> getPerfil(@PathVariable("id") long id) {
		System.out.println("Obteniendo perfil con id " + id);
		Perfil perfil = perfilService.findById(id);
		if (perfil == null) {
			System.out.println("Perfil con id " + id + " no encontrado");
			return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
	}

	// Creo un Perfil
	@RequestMapping(value = "/perfiles/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPerfil(@RequestBody Perfil perfil) {
		System.out.println("Creando el perfil " + perfil.getTipoPerfil());
		if (perfilService.isPerfilExist(perfil)) {
			System.out.println("Ya existe un perfil con nombre " + perfil.getTipoPerfil());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
		}
		perfilService.savePerfil(perfil);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizo un Perfil
	@RequestMapping(value = "/perfiles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Perfil> updatePerfil(@PathVariable("id") long id, @RequestBody Perfil perfil) {
		System.out.println("Actualizando el perfil " + id);
		Perfil currentPerfil = perfilService.findById(id);
		if (currentPerfil == null) {
			System.out.println("Perfil with id " + id + " not found");
			return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
		}
		currentPerfil.setTipoPerfil(perfil.getTipoPerfil());
		perfilService.updatePerfil(currentPerfil);
		return new ResponseEntity<Perfil>(currentPerfil, HttpStatus.OK);
	}

}
