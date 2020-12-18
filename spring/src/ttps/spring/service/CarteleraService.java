package ttps.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.CarteleraDAO;
import ttps.spring.DAOS.UsuarioDAO;
import ttps.spring.DTO.CreateCarteleraDTO;
import ttps.spring.DTO.ErrorCarteleraDTO;
import ttps.spring.DTO.ListaCarteleraDTO;
import ttps.spring.model.Cartelera;
import ttps.spring.model.Usuario;

@Service
@Transactional
public class CarteleraService {
	@Autowired
	CarteleraDAO carteleraDAO;

	@Autowired
	UsuarioDAO usuarioDAO;

	public List<Cartelera> findAllCarteleras() {
		return carteleraDAO.listar();

	}

	public ErrorCarteleraDTO validarCartelera(CreateCarteleraDTO carteleraDTO) {
		ErrorCarteleraDTO back = new ErrorCarteleraDTO();
		if (carteleraDTO.getDocente() == 0) {
			back.setDocenteError("no existe el docente");
		}

		back.setPass(true);
		return back;
	}

	public ErrorCarteleraDTO crearCartelera(CreateCarteleraDTO carteleraDTO, String token) {
		Usuario soyAdmin = (Usuario) usuarioDAO.encontrarPorToken(token);
		if (soyAdmin == null || !soyAdmin.getPerfil().getTipoPerfil().equals("administrador")) {
			ErrorCarteleraDTO currentCarteleraError= new ErrorCarteleraDTO();
			currentCarteleraError.setPass(false);
			return currentCarteleraError;
		}
		
		Usuario currentDueño = (Usuario) usuarioDAO.encontrarPorId(carteleraDTO.getDocente());
		ErrorCarteleraDTO currentCarteleraError = this.validarCartelera(carteleraDTO);
		if (!currentCarteleraError.getPass()) {
			return currentCarteleraError;
		}
		Cartelera currentCartelera = new Cartelera();
		currentCartelera.setInformarcion(carteleraDTO.getInformarcion());
		currentCartelera.setTitulo(carteleraDTO.getTitulo());
		currentCartelera.setSubtitulo(carteleraDTO.getSubtitulo());
		currentCartelera.setDueño(currentDueño);
		carteleraDAO.persistir(currentCartelera);
		return currentCarteleraError;
	}
	
	public List<ListaCarteleraDTO> converToDTO(List<Cartelera> list,String pro) {
		
		List<ListaCarteleraDTO> lista = new ArrayList<ListaCarteleraDTO>();
		for (Iterator<Cartelera> i = list.iterator(); i.hasNext();) {
			Cartelera item = i.next();
			ListaCarteleraDTO temp=new ListaCarteleraDTO(item.getId(),item.getTitulo(),item.getSubtitulo(),pro);
		    lista.add(temp);
		}
		return lista;
	}
	public List<ListaCarteleraDTO> findAllCartelerasPublic() {
		List<ListaCarteleraDTO> listaTemp= this.converToDTO(carteleraDAO.listar(),"usuario publico");
		return listaTemp;
	}
	public List<ListaCarteleraDTO> findAllCartelerasAdmin(Usuario u) {
		List<ListaCarteleraDTO> listaTemp2= this.converToDTO(carteleraDAO.listar(),"admin");
		return listaTemp2;
	}
	
	public List<ListaCarteleraDTO> findAllCartelerasDocente(Usuario u) {
		List<Cartelera> temp=carteleraDAO.listarCartelerasOwner(u.getId());
		List<ListaCarteleraDTO> listaTemp= this.converToDTO(temp,"propietario");

		List<Cartelera> temp2=carteleraDAO.listarCartelerasNoOwner(u.getId());
		List<ListaCarteleraDTO> listaTemp2= this.converToDTO(temp2,"no propietario");
		listaTemp.addAll(listaTemp2);
		return listaTemp;
	}
	public List<ListaCarteleraDTO> findAllCartelerasPublicador(Usuario u) {
		List<Cartelera> mainList = new ArrayList<Cartelera>();
		mainList.addAll(u.getCartelerasDePublicadoresAcceso());
		List<ListaCarteleraDTO> lista= this.converToDTO(mainList,"publicador");
		
		List<Cartelera> allCarteleras=this.findAllCarteleras();
		allCarteleras.removeAll(u.getCartelerasDePublicadoresAcceso());
		
		List<ListaCarteleraDTO> listaTemp2= this.converToDTO(allCarteleras,"no publicador");
		lista.addAll(listaTemp2);
		return lista;
		
	}
	public List<ListaCarteleraDTO> findAllCartelerasAlumno(Usuario u) {
		Set<Cartelera> intereses=u.getCartelerasDeInteres();
		List<Cartelera> mainList = new ArrayList<Cartelera>();
		mainList.addAll(intereses);
		List<ListaCarteleraDTO> listaTemp= this.converToDTO(mainList,"interes");

		List<Cartelera> allCarteleras=this.findAllCarteleras();
		allCarteleras.removeAll(intereses);

		List<ListaCarteleraDTO> listaTemp2= this.converToDTO(allCarteleras,"no interes");
		listaTemp.addAll(listaTemp2);
		return listaTemp;
		
	}
	public List<ListaCarteleraDTO> listar(String token) {
		// encontrar usuario con token
		List<ListaCarteleraDTO> list;
		System.out.println("dentro de listar carteleras");
		if (token.isEmpty()) {
			System.out.println("no hay toquen");
			// listar todas las carteleras para los usuarios publicos
			list = this.findAllCartelerasPublic();
		} else {
			// obtener carteleras segun perfil
			Usuario currentDueño = (Usuario) usuarioDAO.encontrarPorToken(token);
			if (currentDueño.getPerfil().getTipoPerfil().equals("administrador")) {
				System.out.println("listar carteleras como administrador");
				list = this.findAllCartelerasAdmin(currentDueño);
			} else if (currentDueño.getPerfil().getTipoPerfil().equals("docente")) {
				System.out.println("listar carteleras como docente");
				list = this.findAllCartelerasDocente(currentDueño);
			} else if (currentDueño.getPerfil().getTipoPerfil().equals("publicador")) {
				System.out.println("listar carteleras como publicador");
				list = this.findAllCartelerasPublicador(currentDueño);
			} else {
				System.out.println("listar carteleras como alumno");
				list = this.findAllCartelerasAlumno(currentDueño);
			}
		}
		// devolver lista segun perfil
		return list;
	}
}