package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.CreateCarteleraDTO;
import ttps.spring.DTO.ErrorCarteleraDTO;
import ttps.spring.DTO.ListaCarteleraDTO;
import ttps.spring.service.CarteleraService;

@RestController
public class CarteleraRestController {
	@Autowired
	CarteleraService carteleraService;

	// Recupero todas las carteleras dependiendo el tipo de perfil
	@RequestMapping(value = "/carteleras/", method = RequestMethod.GET)
	public ResponseEntity<List<ListaCarteleraDTO>> listAllCarteleras(@RequestHeader("Authorization") String token) {
		
		System.out.println("entre a listar carteleras");
		List<ListaCarteleraDTO> list=carteleraService.listar(token);
		if (list == null) {
			return new ResponseEntity<List<ListaCarteleraDTO>>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<List<ListaCarteleraDTO>>(list, HttpStatus.OK);

	}

	// Creo una cartelera
	@RequestMapping(value = "/carteleras/", method = RequestMethod.POST)
	public ResponseEntity<ErrorCarteleraDTO> createCartelera(@RequestHeader("Authorization") String token,
			@RequestBody CreateCarteleraDTO carteleraDTO) {
		System.out.println("entro a crear carteleras");
		ErrorCarteleraDTO back = carteleraService.crearCartelera(carteleraDTO, token);
		if (!back.getPass()) {
			return new ResponseEntity<ErrorCarteleraDTO>(back, HttpStatus.CONFLICT); // Código de respuesta409
		}
		return new ResponseEntity<ErrorCarteleraDTO>(back, HttpStatus.OK);
	}
}
