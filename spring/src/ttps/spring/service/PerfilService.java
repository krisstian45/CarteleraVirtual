package ttps.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAOS.PerfilDAO;
import ttps.spring.model.Perfil;

@Service
public class PerfilService {
	@Autowired
	PerfilDAO perfil;
	
	
	public List<Perfil> findAllPerfiles() {
		return perfil.listar();

	}

	public Perfil findById(long id) {
		return perfil.encontrarPorId(id);
	}

	public void updatePerfil(Perfil currentPerfil) {
		perfil.actualizar(currentPerfil);
	}
	
	public void savePerfil(Perfil perfil2) {
		perfil.persistir(perfil2);
	}

	public boolean isPerfilExist(Perfil perfil2) {
		return perfil.existePorNombre(perfil2.getTipoPerfil());
	}
}
