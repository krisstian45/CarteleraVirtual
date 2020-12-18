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

import ttps.spring.DTO.CreateNotificacionDTO;
import ttps.spring.model.Notificacion;
import ttps.spring.service.NotificacionService;

@RestController
public class NotificacionRestController {
	@Autowired
	NotificacionService notificacionService;

	// Recupero todos las notificaciones
	@RequestMapping(value = "/notificaciones/", method = RequestMethod.GET)
	public ResponseEntity<List<CreateNotificacionDTO>> listAllNotificaciones() {
		List<CreateNotificacionDTO> notificaciones =notificacionService.listarNotificaciones();
		if (notificaciones == null || notificaciones.isEmpty()) {
			return new ResponseEntity<List<CreateNotificacionDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CreateNotificacionDTO>>(notificaciones, HttpStatus.OK);
	}

	// Recupero una notificacion dada
	@RequestMapping(value = "/notificaciones/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNotificacionDTO> getNotificacion(@PathVariable("id") long id) {
		System.out.println("Obteniendo notificacion con id " + id);
		CreateNotificacionDTO notificacion = notificacionService.encontrarPorId(id);
		if (notificacion == null) {
			System.out.println("Notificacion con id " + id + " no encontrado");
			return new ResponseEntity<CreateNotificacionDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CreateNotificacionDTO>(notificacion, HttpStatus.OK);
	}

	// Creo una notificacion
	@RequestMapping(value = "/notificaciones/", method = RequestMethod.POST)
	public ResponseEntity<Void> createNotificacion(@RequestBody CreateNotificacionDTO notificacion) {
		System.out.println(notificacion.getNombre());
		System.out.println(notificacion.getUsuario());
		System.out.println("Creando la notificacion " + notificacion.getNombre());
		
		if (notificacionService.isNotificacionExist(notificacion.getNombre())) {
			System.out.println("Ya existe una notificacion con nombre " + notificacion.getNombre());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
		}
		notificacionService.saveNotificacionBack(notificacion);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizo una Notificacion
	@RequestMapping(value = "/notificaciones/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Notificacion> updateNotificacion(@PathVariable("id") long id, @RequestBody Notificacion notificacion) {
		System.out.println("Actualizando la notificacion " + id);
		Notificacion currentNotificacion = notificacionService.findById(id);
		if (currentNotificacion == null) {
			System.out.println("Notificacion with id " + id + " not found");
			return new ResponseEntity<Notificacion>(HttpStatus.NOT_FOUND);
		}
		currentNotificacion.setNombre(notificacion.getNombre());
		currentNotificacion.setUsuario(notificacion.getUsuario());
		notificacionService.updateNotificacion(currentNotificacion);
		return new ResponseEntity<Notificacion>(currentNotificacion, HttpStatus.OK);
	}

}
