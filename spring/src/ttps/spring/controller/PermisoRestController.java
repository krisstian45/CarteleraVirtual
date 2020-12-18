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

import ttps.spring.model.Permiso;
import ttps.spring.service.PermisoService;

@RestController
public class PermisoRestController {
	@Autowired
	PermisoService permisoService;

	// Recupero todos los permisos
	@RequestMapping(value = "/permisos/", method = RequestMethod.GET)
	public ResponseEntity<List<Permiso>> listAllPermisos() {
		List<Permiso> permiso = permisoService.findAllPermisos();
		if (permiso.isEmpty()) {
			return new ResponseEntity<List<Permiso>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Permiso>>(permiso, HttpStatus.OK);
	}

	// Recupero un Tag dado
	@RequestMapping(value = "/permisos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Permiso> getPermiso(@PathVariable("id") long id) {
		System.out.println("Obteniendo Tag con id " + id);
		Permiso permiso = permisoService.findById(id);
		if (permiso == null) {
			System.out.println("Tag con id " + id + " no encontrado");
			return new ResponseEntity<Permiso>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Permiso>(permiso, HttpStatus.OK);
	}

	// Creo un tag
	@RequestMapping(value = "/permisos/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPermiso(@RequestBody Permiso permiso) {
		System.out.println("Creando el tag " + permiso.getTipoPermiso());
		if (permisoService.isPermisoExist(permiso)) {
			System.out.println("Ya existe un Tag con nombre " + permiso.getTipoPermiso());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
		}
		permisoService.savePermiso(permiso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizo un Tag
	@RequestMapping(value = "/permisos/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Permiso> updatePermiso(@PathVariable("id") long id, @RequestBody Permiso permiso) {
		System.out.println("Actualizando el usuario " + id);
		Permiso currentPermiso = permisoService.findById(id);
		if (currentPermiso == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Permiso>(HttpStatus.NOT_FOUND);
		}
		currentPermiso.setTipoPermiso(permiso.getTipoPermiso());
		permisoService.updatePermiso(currentPermiso);
		return new ResponseEntity<Permiso>(currentPermiso, HttpStatus.OK);
	}
}

