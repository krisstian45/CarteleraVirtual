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

import ttps.spring.model.Tag;
import ttps.spring.service.TagService;

@RestController
public class TagRestController {
	@Autowired
	TagService tagService;

	// Recupero todos los tags
	@RequestMapping(value = "/tags/", method = RequestMethod.GET)
	public ResponseEntity<List<Tag>> listAllTags() {
		List<Tag> tags = tagService.findAllTags();
		if (tags.isEmpty()) {
			return new ResponseEntity<List<Tag>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tag>>(tags, HttpStatus.OK);
	}

	// Recupero un Tag dado
	@RequestMapping(value = "/tags/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tag> getTag(@PathVariable("id") long id) {
		System.out.println("Obteniendo Tag con id " + id);
		Tag tag = tagService.findById(id);
		if (tag == null) {
			System.out.println("Tag con id " + id + " no encontrado");
			return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Tag>(tag, HttpStatus.OK);
	}

	// Creo un tag
	@RequestMapping(value = "/tags/", method = RequestMethod.POST)
	public ResponseEntity<Void> createTag(@RequestBody Tag tag) {
		System.out.println("Creando el tag " + tag.getNombreTag());
		if (tagService.isTagExist(tag)) {
			System.out.println("Ya existe un Tag con nombre " + tag.getNombreTag());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); // Código de respuesta 409
		}
		tagService.saveTag(tag);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Actualizo un Tag
	@RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tag> updateTag(@PathVariable("id") long id, @RequestBody Tag tag) {
		System.out.println("Actualizando el usuario " + id);
		Tag currentTag = tagService.findById(id);
		if (currentTag == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
		}
		currentTag.setNombreTag(tag.getNombreTag());
		tagService.updateTag(currentTag);
		return new ResponseEntity<Tag>(currentTag, HttpStatus.OK);
	}
}