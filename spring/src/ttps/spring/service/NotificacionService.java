package ttps.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.NotificacionDAO;
import ttps.spring.DTO.CreateNotificacionDTO;
import ttps.spring.model.Notificacion;

@Service
@Transactional
public class NotificacionService {
	@Autowired
	NotificacionDAO notificacionDAO;
	@Autowired
	UserService user;
	@Autowired
	NotificacionService notificacionService;

	public List<Notificacion> findAllNotificaciones() {
		return notificacionDAO.listar();
	}
	public void saveNotificacionBack(CreateNotificacionDTO notifiDTO){
		Notificacion notificacion= new Notificacion();
		notificacion.setNombre(notifiDTO.getNombre());
		System.out.println(user.findById(notifiDTO.getUsuario()).getNombre());
		notificacion.setUsuario(user.findById(notifiDTO.getUsuario()));
		saveNotificacion(notificacion);
	}
	
	public List<CreateNotificacionDTO> listarNotificaciones(){
		List<Notificacion> notificacionesCurrents = notificacionService.findAllNotificaciones();
		List<CreateNotificacionDTO> lista = new ArrayList<CreateNotificacionDTO>();
		for (Iterator<Notificacion> i = notificacionesCurrents.iterator(); i.hasNext();) {
		    Notificacion item = i.next();
		    CreateNotificacionDTO temp=new CreateNotificacionDTO(item.getNombre(),item.getUsuario().getId());
		    lista.add(temp);
		}
		return lista;
	}
	public CreateNotificacionDTO encontrarPorId(Long id) {
		Notificacion temp=this.findById(id);
		CreateNotificacionDTO current= new CreateNotificacionDTO(temp.getNombre(),temp.getUsuario().getId());
		return current;
	}
	public Notificacion findById(long id) {
		return notificacionDAO.encontrarPorId(id);
	}

	public void updateNotificacion(Notificacion currentNotificacion) {
		notificacionDAO.actualizar(currentNotificacion);
	}

	public void saveNotificacion(Notificacion noti) {
		notificacionDAO.persistir(noti);
	}

	public boolean isNotificacionExist(String nombre) {
		return notificacionDAO.existePorNombre(nombre);
	}

}
